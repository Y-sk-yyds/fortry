package com.example.fortry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fortry.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
