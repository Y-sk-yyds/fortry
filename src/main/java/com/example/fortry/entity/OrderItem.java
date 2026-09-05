package com.example.fortry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@TableName("`order_item`")
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long dishId;
    private Long quantity;
    private BigDecimal price;
    private LocalDateTime createTime;

}
