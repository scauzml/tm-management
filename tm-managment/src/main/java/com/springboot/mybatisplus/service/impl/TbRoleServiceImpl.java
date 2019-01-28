package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbRoleMapper;
import com.springboot.mybatisplus.entity.TbRole;
import com.springboot.mybatisplus.service.ITbRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbRoleServiceImpl extends ServiceImpl<TbRoleMapper, TbRole> implements ITbRoleService {

}
