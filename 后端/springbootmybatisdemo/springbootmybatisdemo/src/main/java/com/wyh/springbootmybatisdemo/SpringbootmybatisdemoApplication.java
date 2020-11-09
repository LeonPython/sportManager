package com.wyh.springbootmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyh.springbootmybatisdemo.mapper")
public class SpringbootmybatisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmybatisdemoApplication.class, args);
    }

}
