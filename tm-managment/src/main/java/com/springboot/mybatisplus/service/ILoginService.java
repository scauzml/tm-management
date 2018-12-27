package com.springboot.mybatisplus.service;


import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.Role;
import com.springboot.mybatisplus.entity.User;

import java.util.Map;

/**
 * @author{张明亮} 2018/12/23 21:49
 */
public interface ILoginService extends IService<User> {
    User addUser(Map<String, Object> map);
    Role addRole(Map<String, Object> map);
    User findByName(String name);
}
