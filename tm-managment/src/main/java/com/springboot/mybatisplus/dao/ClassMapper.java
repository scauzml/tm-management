package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.entity.TbClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班级 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface ClassMapper extends BaseMapper<TbClass> {
    List<TbClass> getListClass(Page<TbClass> page, Map<String, Object> params);

}
