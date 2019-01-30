package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface NoticeMapper extends BaseMapper<TbNotice> {
    List<TbNotice> getListNotice(Page<TbNotice> page, Map<String, Object> params);

}
