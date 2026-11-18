package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
public class WebMvcConfig implements WebMvcConfigurer {

}

//@ConfigurationはSpringの設定クラスとして登録
//@EnableWebMvcはSpring MVCを有効化
//@ComponentScanはControllerなどを自動検出
//WebMvcConfigurerはMVCの追加設定を行うためのインターフェース
