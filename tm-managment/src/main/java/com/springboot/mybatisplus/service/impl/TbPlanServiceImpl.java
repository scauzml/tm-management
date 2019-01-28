package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbPlanMapper;
import com.springboot.mybatisplus.entity.TbPlan;
import com.springboot.mybatisplus.service.ITbPlanService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 计划 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbPlanServiceImpl extends ServiceImpl<TbPlanMapper, TbPlan> implements ITbPlanService {

}
