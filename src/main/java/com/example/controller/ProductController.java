package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class ProductController {
	private final JdbcTemplate jdbcTemplate;
	public ProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/products")
    public String index() {
        return "products/index";
    }
    
    @GetMapping("/products/db-test")
    @ResponseBody
    public String dbTest() {
    	try {
            String databaseName = jdbcTemplate.queryForObject(
                "SELECT DATABASE()",
                String.class
            );
            return "MySQL CONNECTION SUCCESS! Database: "
                    + databaseName;
        } catch (Exception e) {
            e.printStackTrace();
            return "MySQL CONNECTION ERROR: "
                    + e.getClass().getSimpleName()
                    + " : "
                    + e.getMessage();
        }
    }
}
