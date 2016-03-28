package controller;

import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Khartonov Oleg on 08.03.2016.
 */
@RestController
public class OrderController {

    private final String SQL_GET_LIST_ORDER = "select * from bill where user_id = ?";
    private final String SQL_GET_BILL_INFO = "select * from bill where id = ?";
    private final String SQL_INSERT_NEW_ORDER = "insert into bill (id, sum, products, address, user_id) values (?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/user/{userId}/order/")
    public List<Order> getOrderList(@PathVariable int userId){
       List<Order> orders =jdbcTemplate.query(SQL_GET_LIST_ORDER, new Object[]{userId},
               (rs, i) -> {
                   return new Order(rs.getInt("id"), rs.getInt("sum"), rs.getString("products"), rs.getString("address"), rs.getInt("user_id"));
               });
        return orders;
    }

    @RequestMapping("/order/{orderId}")
    public String getOrderInfo(@PathVariable int orderId){
        return jdbcTemplate.queryForObject(SQL_GET_BILL_INFO, new Object[]{orderId},
                (rs, s)-> {
                    return new Order(rs.getInt("id"), rs.getInt("sum"), rs.getString("products"), rs.getString("address"), rs.getInt("user_id")).toString();
                });
    }

    @RequestMapping("/user/{userId}/newOrder/order={orderId}&sum={sum}&products={products}&address={address}")
    public String create1NewOrder(@PathVariable int userId, @PathVariable int orderId, @PathVariable int sum, @PathVariable String protucts, @PathVariable String address){
        jdbcTemplate.update(SQL_INSERT_NEW_ORDER, new Object[]{orderId, sum, protucts, address, userId});
        return "Order was created success";
    }

}
