package com.example.fortry.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fortry.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Map<String,Object>> getOrderStatus(@Param("age") Integer age);
}
