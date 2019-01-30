package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.ClassMapper;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.service.ClassService;
import com.springboot.mybatisplus.util.id.DistributedIdGenerator;
import com.springboot.mybatisplus.util.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassMapper, TbClass> implements ClassService {

    @Override
    public PageObject<TbClass> getClassPage(Map<String, Object> params) {

        Page<TbClass> page = new Query<TbClass>(params).getPage();

        List<TbClass> list = baseMapper.getListClass(page, params);
        page.setRecords(list);
        return new PageObject<TbClass>(page);
    }

    @Override
    public void save(TbClass tbClass) {

        String id = DistributedIdGenerator.generateId().toString();
        tbClass.setId(id);
        baseMapper.insert(tbClass);
    }

    @Override
    public void update(TbClass tbClass) {
        baseMapper.updateById(tbClass);
    }

    @Override
    public void delete(TbClass tbClass) {
        baseMapper.updateById(tbClass);
    }
}
