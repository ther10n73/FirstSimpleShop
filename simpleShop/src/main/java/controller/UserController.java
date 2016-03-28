package controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Khartonov Oleg on 08.03.2016.
 */
@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_ADD_PERSON = "insert into person (user_id, balance, address, fio)\n" +
            "values (?,?,?,?)";
    private final String SQL_PERSON_INFO = "select * from person where user_id = ?";

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getInfoByUser(@PathVariable int userId){
       return (User) jdbcTemplate.queryForObject(SQL_PERSON_INFO, new Object[]{userId}, new RowMapper() {
           @Override
           public User mapRow(ResultSet resultSet, int i) throws SQLException {
               return new User(resultSet.getInt("user_id"), resultSet.getInt("balance"), resultSet.getString("address"), resultSet.getString("fio"));
           }
       });
    }

    @RequestMapping(value = "/user/registration/userId={userId}&bal={balance}&adr={address}&fio={fio}", method = RequestMethod.GET)
    public String createNewUser(@PathVariable int userId, @PathVariable int balance, @PathVariable String address, @PathVariable String fio){
        try {
            jdbcTemplate.update(SQL_ADD_PERSON, new Object[]{userId, balance, address, fio});
            return "Registration success: " + getInfoByUser(userId).toString();
        } catch (Exception e){
            return "Registration fail: " + e.getMessage();
        }

    }
}
