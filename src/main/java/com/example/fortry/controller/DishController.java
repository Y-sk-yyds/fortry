package com.example.fortry.controller;

import com.example.fortry.common.Result;
import com.example.fortry.entity.Dish;
import com.example.fortry.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("dish")
public class DishController {
    @Autowired
    private DishMapper dishMapper;

    @GetMapping("/listall")
    public Result<List<Dish>> getAllDish(){
        return Result.success(dishMapper.selectList(null));
    }
}
