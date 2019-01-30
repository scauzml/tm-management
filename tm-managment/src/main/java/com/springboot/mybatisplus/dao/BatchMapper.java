package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbBatch;
import com.springboot.mybatisplus.util.PageObject;
import com.springboot.mybatisplus.vo.systemvo.BatchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 批次 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface BatchMapper extends BaseMapper<TbBatch> {
    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 16:32
     * @Param: null
    * @description {查询列表}
     */
    List<BatchVo> selectBatch(Page<BatchVo> page, Map<String, Object> params);
}
