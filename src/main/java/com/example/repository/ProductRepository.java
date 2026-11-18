package com.example.repository;

import java.sql.Timestamp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.model.Product;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    // JdbcTemplateを受け取る
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 商品をMySQLに登録する
    public int insert(Product product) {
        String sql = """
            INSERT INTO products
            (product_name, price, startdate, stock)
            VALUES (?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
            sql,
            product.getProductName(),
            product.getPrice(),
            Timestamp.valueOf(product.getStartdate()),
            product.getStock()
        );
    }
}
