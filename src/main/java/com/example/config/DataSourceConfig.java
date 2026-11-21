package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    // MySQLとの接続設定
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "com.mysql.cj.jdbc.Driver");

        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/products_db"
                + "?useSSL=false"
                + "&allowPublicKeyRetrieval=true"
                + "&serverTimezone=Asia/Tokyo"
                + "&characterEncoding=UTF-8");

        dataSource.setUsername("root");
        // 自分のMySQLのパスワードに変更してください
        dataSource.setPassword("root1234");
        return dataSource;
    }

    // SQL実行用のJdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
