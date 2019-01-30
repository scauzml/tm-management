package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbBatch;
import com.springboot.mybatisplus.util.PageObject;
import com.springboot.mybatisplus.vo.systemvo.BatchVo;

import java.util.Map;

/**
 * <p>
 * 批次 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface BatchService extends IService<TbBatch> {

    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 15:32
     * @Param: nll
     * @description {查询批次列表}
     */
    PageObject<BatchVo> getBatchPage(Map<String, Object> params);

    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 17:24
     * @Param: nll
     * @description {保存批次}
     */
    void save(TbBatch tbBatch);

    /**
     *@author {张明亮}
     *@date 2019/1/29 18:38
     * @Param: null
     *@return
     *@description {更新}
     *
     */
    void update(TbBatch tbBatch);

    /**
     *@author {张明亮}
     *@date 2019/1/29 18:41
     * @Param: null
     *@return
     *@description {逻辑删除}
     *
     */
    void delete(TbBatch tbBatch);
}
