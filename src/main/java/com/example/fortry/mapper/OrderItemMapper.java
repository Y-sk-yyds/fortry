package com.example.fortry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fortry.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
