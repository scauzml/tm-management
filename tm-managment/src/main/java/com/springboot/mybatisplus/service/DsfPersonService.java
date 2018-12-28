package com.springboot.mybatisplus.service;


import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.DsfPersonEntity;
import com.springboot.mybatisplus.util.PageUtils;

import java.util.Map;

/**
 * 人员表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:52:53
 */
public interface DsfPersonService extends IService<DsfPersonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

