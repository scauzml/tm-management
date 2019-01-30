package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbAcademy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学院 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface AcademyMapper extends BaseMapper<TbAcademy> {

    List<TbAcademy> getListAcademy(Page<TbAcademy> page, Map<String, Object> params);
}
