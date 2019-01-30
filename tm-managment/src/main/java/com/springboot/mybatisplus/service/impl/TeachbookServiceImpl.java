package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TeachbookMapper;
import com.springboot.mybatisplus.entity.TbTeachbook;
import com.springboot.mybatisplus.service.TeachbookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教材 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service("teachbookService")
public class TeachbookServiceImpl extends ServiceImpl<TeachbookMapper, TbTeachbook> implements TeachbookService {

}
