package com.example.fortry.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderInfoDTO {
    private Long id;
    private Long userId;
    private BigDecimal amount;
}
