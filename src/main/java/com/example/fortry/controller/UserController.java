package com.example.fortry.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fortry.common.Result;
import com.example.fortry.dto.OrderInfoDTO;
import com.example.fortry.dto.request.RegisterInfoDTO;
import com.example.fortry.dto.request.UserLoginDTO;
import com.example.fortry.dto.response.OrdersForShowDTO;
import com.example.fortry.entity.Order;
import com.example.fortry.entity.User;
import com.example.fortry.exception.BusinessException;
import com.example.fortry.mapper.OerderMapper;
import com.example.fortry.mapper.UserMapper;
import com.example.fortry.utils.jwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OerderMapper oerderMapper;
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
    public Result<List<OrderInfoDTO>> getUserOrders(@RequestParam(required = false) Long userID){
       QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        if (userID==null) {
            return Result.error("请输入userId！");
        }

        //注意，这里的两个参数，前面者是和数据库字段名字对其
        //而后者是和前端的传值对其
        queryWrapper.eq("user_id",userID);


        List<Order> orders= oerderMapper.selectList(queryWrapper);

        List<OrderInfoDTO> ordersForShowDTO=orders.stream()
                .map(order -> {
                    OrderInfoDTO dto=new OrderInfoDTO();
                    dto.setUserId(order.getUserId());
                    dto.setId(order.getId());
                    dto.setAmount(order.getAmount());
                    return dto;
        }).toList();

        return Result.success(ordersForShowDTO);
    }
}
