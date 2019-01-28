package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbStoreMapper;
import com.springboot.mybatisplus.entity.TbStore;
import com.springboot.mybatisplus.service.ITbStoreService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class TbStoreServiceImpl extends ServiceImpl<TbStoreMapper, TbStore> implements ITbStoreService {

}
