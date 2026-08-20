package com.example.fortry.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private long balance;
    private LocalDateTime createTime =LocalDateTime.now();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
