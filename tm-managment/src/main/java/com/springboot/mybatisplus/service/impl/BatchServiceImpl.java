package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.BatchMapper;
import com.springboot.mybatisplus.entity.TbBatch;
import com.springboot.mybatisplus.service.BatchService;
import com.springboot.mybatisplus.util.PageObject;
import com.springboot.mybatisplus.util.query.Query;
import com.springboot.mybatisplus.vo.systemvo.BatchVo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 批次 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service("batchService")
public class BatchServiceImpl extends ServiceImpl<BatchMapper, TbBatch> implements BatchService {

    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 15:32
     * @Param: nll
     * @description {查询批次列表}
     */
    @Override
    public PageObject<BatchVo> getBatchPage(Map<String, Object> params) {
        Page<BatchVo> page = new Query<BatchVo>(params).getPage();
        List<BatchVo> list = baseMapper.selectBatch(page, params);

        page.setRecords(list);
        return new PageObject<BatchVo>(page);
    }

    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 17:24
     * @Param: nll
     * @description {保存批次}
     */
    @Override
    public void save(TbBatch tbBatch) {

        Date date= new Date();
      tbBatch.setCreatePeople("111");
      tbBatch.setIsDel(0);
      tbBatch.setModifyPeople("111");
      tbBatch.setCreateTime(date);
      tbBatch.setModifyTime(date);
      baseMapper.insert(tbBatch);

    }

    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 21:00
     * @Paam: null
     * @description {更新}
     */
    @Override
    public void update(TbBatch tbBatch) {
        Date date= new Date();
        tbBatch.setModifyPeople("111");
        tbBatch.setModifyTime(date);
        baseMapper.updateById(tbBatch);
    }
    /**
     * @return a
     * @author {张明亮}
     * @date 2019/1/29 21:00
     * @Paam: null
     * @description {删除}
     */
    @Override
    public void delete(TbBatch tbBatch) {
        Date date= new Date();
        tbBatch.setIsDel(1);
        tbBatch.setModifyPeople("111");
        tbBatch.setModifyTime(date);
        baseMapper.updateById(tbBatch);

    }
}
