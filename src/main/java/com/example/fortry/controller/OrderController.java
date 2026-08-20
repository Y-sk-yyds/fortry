package com.example.fortry.controller;

import com.example.fortry.common.Result;
import com.example.fortry.serrvice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/ordercreate")
    public Result<String> buyorder(@RequestParam Long userId,@RequestParam long amount){
        orderService.createOrder(userId,amount);
        return Result.success("下单成功!");
    }
}
