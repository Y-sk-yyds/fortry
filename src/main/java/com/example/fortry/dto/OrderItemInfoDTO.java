package com.example.fortry.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemInfoDTO {
    private Long dishId;
    private Long quantity;
    private BigDecimal price;
}
