package com.example.fortry.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoDTO {
    private String username;
    private int age;
    private LocalDateTime createTime;

    public UserInfoDTO(String username, int age, LocalDateTime createTime) {
        this.username = username;
        this.age = age;
        this.createTime = createTime;
    }
}
