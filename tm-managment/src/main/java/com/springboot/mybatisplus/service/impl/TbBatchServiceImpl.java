package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbBatchMapper;
import com.springboot.mybatisplus.entity.TbBatch;
import com.springboot.mybatisplus.service.ITbBatchService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 批次 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbBatchServiceImpl extends ServiceImpl<TbBatchMapper, TbBatch> implements ITbBatchService {

}
