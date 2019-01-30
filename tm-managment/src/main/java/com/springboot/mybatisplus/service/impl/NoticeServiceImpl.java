package com.springboot.mybatisplus.service.impl;

;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.NoticeMapper;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbNotice;

import com.springboot.mybatisplus.service.NoticeService;
import com.springboot.mybatisplus.util.id.DistributedIdGenerator;
import com.springboot.mybatisplus.util.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, TbNotice> implements NoticeService {

    @Override
    public PageObject<TbNotice> getNoticePage(Map<String, Object> params) {

        Page<TbNotice> page = new Query<TbNotice>(params).getPage();
        List<TbNotice> list = baseMapper.getListNotice(page, params);
        page.setRecords(list);
        return new PageObject<TbNotice>(page);
    }

    @Override
    public void save(TbNotice tbNotice) {
        String id = DistributedIdGenerator.generateId().toString();
        tbNotice.setId(id);
        baseMapper.insert(tbNotice);
    }

    @Override
    public void update(TbNotice tbNotice) {
        baseMapper.updateById(tbNotice);
    }

    @Override
    public void delete(TbNotice tbNotice) {
        baseMapper.updateById(tbNotice);
    }
}
