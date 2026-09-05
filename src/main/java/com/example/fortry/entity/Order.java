package com.example.fortry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("`orders`")
public class Order {
    private Long id;
    private long userId;
    private BigDecimal amount;
    private LocalDateTime createTime=LocalDateTime.now();

    public Order(long userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
