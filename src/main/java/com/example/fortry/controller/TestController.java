package com.example.fortry.controller;

import com.example.fortry.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
    @GetMapping("/hello")
    public String hello(){
        throw new BusinessException("这是我写的异常");
    }
}
