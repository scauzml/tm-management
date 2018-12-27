package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.User;

import java.util.List;

/**
 * @author{张明亮} 2018/12/23 21:48
 */
public interface UserMapper extends BaseMapper<User> {
    User findByName(String name);

    List<User> customSql(User user);


}
