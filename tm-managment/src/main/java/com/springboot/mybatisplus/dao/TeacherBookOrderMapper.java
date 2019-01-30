package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.entity.TbTeacherBookOrder;
import com.springboot.mybatisplus.vo.TeachbookOrderVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 教师征订子单 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface TeacherBookOrderMapper extends BaseMapper<TbTeacherBookOrder> {

     List<TeachbookOrderVo> selectTeachBookOrderlist(Page<TeachbookOrderVo> page, Map<String, Object> params);

}
