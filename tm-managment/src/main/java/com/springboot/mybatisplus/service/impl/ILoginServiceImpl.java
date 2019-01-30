package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.UserMapper;
import com.springboot.mybatisplus.entity.Role;
import com.springboot.mybatisplus.entity.User;
import com.springboot.mybatisplus.service.ILoginService;


import java.util.Map;

/**
 * @author{张明亮} 2018/12/23 21:49
 */
public class ILoginServiceImpl  extends ServiceImpl<UserMapper, User> implements ILoginService {


    @Override
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));

        return user;
    }

    @Override
    public Role addRole(Map<String, Object> map) {
       return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }
}
