package com.example.fortry.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Dish {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private LocalDateTime createTime;
}
