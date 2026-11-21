package com.example.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DbTestController {
    private final JdbcTemplate jdbcTemplate;
    public DbTestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/db-test")
    @ResponseBody
    public String testConnection() {
        String databaseName =
                jdbcTemplate.queryForObject(
                        "SELECT DATABASE()",
                        String.class
                );
        return "MySQL接続成功:データベース名：" + databaseName;
    }
}
