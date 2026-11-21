package com.example.repository;

import java.sql.Timestamp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.model.Product;
import java.util.List;

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
    
    //登録データを一覧に表示する
    public List<Product> findAll() {

        String sql = """
            SELECT id, product_name, price, startdate, stock
            FROM products
            ORDER BY id
            """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Product product = new Product();

            product.setId(rs.getLong("id"));
            product.setProductName(rs.getString("product_name"));
            product.setPrice(rs.getInt("price"));

            Timestamp timestamp = rs.getTimestamp("startdate");

            if (timestamp != null) {
                product.setStartdate(timestamp.toLocalDateTime());
            }

            product.setStock(rs.getInt("stock"));

            return product;
        });
    }
}
