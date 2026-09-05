package com.example.fortry.dto.request;

import lombok.Data;

@Data
public class RegisterInfoDTO {
    private String username;
    private String password;
    private int age;
    private long balance=0;

    public RegisterInfoDTO(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
