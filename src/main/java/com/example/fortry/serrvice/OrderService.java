package com.example.fortry.serrvice;

import com.example.fortry.common.Result;
import com.example.fortry.entity.Order;
import com.example.fortry.entity.User;
import com.example.fortry.mapper.OerderMapper;
import com.example.fortry.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OerderMapper oerderMapper;
    public void createOrder(Long userId, long amount) {
        User user=userMapper.selectById(userId);
        if(user==null){
            System.out.println("haven't fount it");
            return;
        }
        if (user.getBalance()-amount<0){
            System.out.println("余额不足");
            return;
        }
        user.setBalance( (user.getBalance()-amount));
        userMapper.updateById(user);

        Order order=new Order();
        order.setAmount(amount);
        order.setUserId(userId);

        oerderMapper.insert(order);
    }
}
