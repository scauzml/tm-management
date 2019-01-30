package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.springboot.mybatisplus.dao.TeacherBookOrderMapper;
import com.springboot.mybatisplus.entity.TbTeacherBookOrder;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.service.TeacherBookOrderService;
import com.springboot.mybatisplus.util.query.Query;
import com.springboot.mybatisplus.vo.TeachbookOrderVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师征订子单 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service("teacherBookOrderService")
public class TeacherBookOrderServiceImpl extends ServiceImpl<TeacherBookOrderMapper, TbTeacherBookOrder> implements TeacherBookOrderService {


    @Override
    public PageObject<TeachbookOrderVo> getTeachBookOrderPage(Map<String, Object> params) {
        Page<TeachbookOrderVo> page = new Query<TeachbookOrderVo>(params).getPage();

        List<TeachbookOrderVo> list = baseMapper.selectTeachBookOrderlist(page, params);
        page.setRecords(list);
        return new PageObject<TeachbookOrderVo>(page);
    }
}
