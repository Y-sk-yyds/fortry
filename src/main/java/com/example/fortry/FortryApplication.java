package com.example.fortry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fortry.mapper")
public class FortryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortryApplication.class, args);
    }
}