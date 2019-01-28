package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbClassMapper;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.service.ITbClassService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbClassServiceImpl extends ServiceImpl<TbClassMapper, TbClass> implements ITbClassService {

}
