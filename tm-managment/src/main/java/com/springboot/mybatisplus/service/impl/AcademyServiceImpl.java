package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.AcademyMapper;
import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.service.AcademyService;
import com.springboot.mybatisplus.util.PageObject;
import com.springboot.mybatisplus.util.id.DistributedIdGenerator;
import com.springboot.mybatisplus.util.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学院 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service("academyService")
public class AcademyServiceImpl extends ServiceImpl<AcademyMapper, TbAcademy> implements AcademyService {

    @Override
    public PageObject<TbAcademy> getTbAcademyPage(Map<String, Object> params) {

        Page<TbAcademy> page = new Query<TbAcademy>(params).getPage();

        List<TbAcademy> list = baseMapper.getListAcademy(page, params);
        page.setRecords(list);
        return new PageObject<TbAcademy>(page);
    }

    @Override
    public void save(TbAcademy tbAcademy) {
        String id = DistributedIdGenerator.generateId().toString();
        tbAcademy.setId(id);
        baseMapper.insert(tbAcademy);
    }

    @Override
    public void update(TbAcademy tbAcademy) {
       baseMapper.updateById(tbAcademy);
    }

    @Override
    public void delete(TbAcademy tbAcademy) {
        baseMapper.updateById(tbAcademy);
    }
}
