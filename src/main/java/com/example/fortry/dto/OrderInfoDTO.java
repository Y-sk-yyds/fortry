package com.example.fortry.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderInfoDTO {
    private int id;
    private int userId;
    private int amount;
}
