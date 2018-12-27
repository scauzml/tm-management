package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.SecUserRoleMapper;
import com.springboot.mybatisplus.entity.SecUserRole;
import com.springboot.mybatisplus.service.SecUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author zhangmingliang
 * @date 2018-12-27 18:09
 */
@Service("secUserRoleService")
public class SecUserRoleServiceImpl extends ServiceImpl<SecUserRoleMapper, SecUserRole> implements SecUserRoleService {
}
