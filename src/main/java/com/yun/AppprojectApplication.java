package com.yun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.yun.dao")
@SpringBootApplication
public class AppprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppprojectApplication.class, args);
    }

}
