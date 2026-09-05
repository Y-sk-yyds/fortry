package com.example.fortry.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private int age;
    private BigDecimal balance;
    private LocalDateTime createTime =LocalDateTime.now();

    public User(String username, String password,int age) {
        this.username = username;
        this.password = password;
        this.age=age;
    }

    public User() {
    }
}
