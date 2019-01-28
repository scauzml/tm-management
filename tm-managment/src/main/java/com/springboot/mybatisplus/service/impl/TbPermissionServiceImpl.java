package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbPermissionMapper;
import com.springboot.mybatisplus.entity.TbPermission;
import com.springboot.mybatisplus.service.ITbPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionMapper, TbPermission> implements ITbPermissionService {

}
