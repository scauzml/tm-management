package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbTeacherBookOrder;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.vo.TeachbookOrderVo;

import java.util.Map;

/**
 * <p>
 * 教师征订子单 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface TeacherBookOrderService extends IService<TbTeacherBookOrder> {

    /**
     * @author zml
     *
     * @param null
     * @return
     * 查询教师征订表单列表
     *
     */
    PageObject<TeachbookOrderVo> getTeachBookOrderPage(Map<String, Object> params);
}
