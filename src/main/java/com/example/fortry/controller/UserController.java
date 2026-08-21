package com.example.fortry.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fortry.common.Result;
import com.example.fortry.dto.RegisterInfoDTO;
import com.example.fortry.dto.UserLoginDTO;
import com.example.fortry.entity.User;
import com.example.fortry.exception.BusinessException;
import com.example.fortry.mapper.UserMapper;
import com.example.fortry.utils.jwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/login")
    public Result<User> login(@Valid @RequestBody UserLoginDTO dto){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",dto.getUsername());
        User user=userMapper.selectOne(wrapper);

        if(user==null||!user.getPassword().equals(dto.getPassword())){
            throw new BusinessException("用户名或者密码错误");
        }

        String token= jwtUtil.generateToken(user.getUsername());

        return Result.success(token);
    }
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterInfoDTO dto){
        User user=new User(dto.getUsername(), dto.getPassword(),dto.getAge());
        int f=userMapper.insert(user);
        System.out.println("look ! this is: "+f+"\n");
        return Result.success("created!");
    }
    @GetMapping("/select/person")
    public Result<User> selectByName(@RequestParam String username)
    {
        QueryWrapper<User> wrapper=new QueryWrapper();
        wrapper.eq("username",username);
        User user=userMapper.selectOne(wrapper);
        return Result.success(user);
    }
    @GetMapping("/getidstatus")
    public Result<List<Map<String,Object>>> getUserOrders(@RequestParam(required = false) Integer age){
        return Result.success(userMapper.getOrderStatus(age));
    }
}
