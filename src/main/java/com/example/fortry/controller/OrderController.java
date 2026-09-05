package com.example.fortry.controller;

import com.example.fortry.common.Result;
import com.example.fortry.dto.request.CreateOrderItemDTO;
import com.example.fortry.serrvice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public Result<String> createOrder(@RequestBody CreateOrderItemDTO createOrderItemDTO){
        orderService.createOrder(createOrderItemDTO.getUserId(),createOrderItemDTO.getOrderItemInfoDTOS());
        return Result.success("下单成功!");
    }
}
