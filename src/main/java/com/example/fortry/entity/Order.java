package com.example.fortry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("`orders`")
public class Order {
    private int id;
    private long userId;
    private long amount;
    private LocalDateTime createTime=LocalDateTime.now();
}
