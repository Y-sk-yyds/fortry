package com.example.fortry.serrvice;

import com.example.fortry.common.Result;
import com.example.fortry.dto.OrderItemInfoDTO;
import com.example.fortry.entity.Order;
import com.example.fortry.entity.OrderItem;
import com.example.fortry.entity.User;
import com.example.fortry.mapper.OerderMapper;
import com.example.fortry.mapper.OrderItemMapper;
import com.example.fortry.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OerderMapper oerderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Transactional
    public void createOrder(Long userId, List<OrderItemInfoDTO> orderItemInfoDTOS) {
        User user=userMapper.selectById(userId);
        if(user==null){
            throw new RuntimeException("用户不存在，请先登录");
        }

        BigDecimal amount=orderItemInfoDTOS.stream()
                .map(orderItemInfoDTO -> orderItemInfoDTO.getPrice().multiply(BigDecimal.valueOf(orderItemInfoDTO.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        if (user.getBalance().compareTo(amount)<0){
            System.out.println("余额不足");
            throw new RuntimeException("余额不足");
        }
        user.setBalance( (user.getBalance().subtract(amount)));
        userMapper.updateById(user);

        Order order=new Order(userId,amount);
        oerderMapper.insert(order);

        orderItemInfoDTOS.stream().forEach(item->{
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setDishId(item.getDishId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getPrice()); // 单价
            // 如果需要存小计，可以在实体加字段，但一般存单价和数量，小计可以查询时计算
            orderItemMapper.insert(orderItem);
        });
    }
}
