package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.TbTeachbook;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 教材 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface TeachbookMapper extends BaseMapper<TbTeachbook> {


}
