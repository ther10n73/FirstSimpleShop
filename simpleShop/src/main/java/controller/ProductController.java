package controller;

import models.Product;
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
public class ProductController {

    private final String SQL_ALL_PRODUCTS = "select * from products";
    private final String SQL_GET_INFO_PRODUCTS = "select * from products where id =?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private StringBuilder str = new StringBuilder();

    @RequestMapping("/product")
    public String getProducts(){
        List<Product> products= jdbcTemplate.query(SQL_ALL_PRODUCTS,
                (rs, p) -> {
                    return new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("info"));
                });
        for (Product p: products){
            str.append(p.toString()).append("\t\n");
        }
        return str.toString();
    }

    @RequestMapping("/product/{productId}")
    public String getProductInfo(@PathVariable int productId){
        return jdbcTemplate.queryForObject(SQL_GET_INFO_PRODUCTS, new Object[]{productId},
                (rs, p) -> {
                    return new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("info")).toString();
                });
    }
}