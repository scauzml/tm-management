package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.DsfPersonEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人员表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:52:53
 */
@Mapper
public interface DsfPersonDao extends BaseMapper<DsfPersonEntity> {

}
