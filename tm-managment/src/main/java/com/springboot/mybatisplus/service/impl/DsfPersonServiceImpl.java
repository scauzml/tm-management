package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.DsfPersonDao;
import com.springboot.mybatisplus.entity.DsfPersonEntity;
import com.springboot.mybatisplus.service.DsfPersonService;
import com.springboot.mybatisplus.util.PageUtils;
import com.springboot.mybatisplus.util.query.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service("dsfPersonService")
public class DsfPersonServiceImpl extends ServiceImpl<DsfPersonDao, DsfPersonEntity> implements DsfPersonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String personName = (String) params.get("personName");
        Integer gender = (Integer) params.get("gender");
        String title = (String) params.get("title");
        String telephone = (String) params.get("telephone");
        String email = (String) params.get("email");
        String avatar = (String) params.get("avatar");
        String address = (String) params.get("address");
        String remark = (String) params.get("remark");
        String extattr = (String) params.get("extattr");
        Date gmtCreated = (Date) params.get("gmtCreated");
        Date gmtModified = (Date) params.get("gmtModified");
        String gmtAuthor = (String) params.get("gmtAuthor");
        Page<DsfPersonEntity> page = this.selectPage(
                new Query<DsfPersonEntity>(params).getPage(),
                new EntityWrapper<DsfPersonEntity>()
                        .like(StringUtils.isNotEmpty(personName), "person_name", personName)
                        .eq(gender != null, "gender", gender)
                        .like(StringUtils.isNotEmpty(title), "title", title)
                        .like(StringUtils.isNotEmpty(telephone), "telephone", telephone)
                        .like(StringUtils.isNotEmpty(email), "email", email)
                        .like(StringUtils.isNotEmpty(avatar), "avatar", avatar)
                        .like(StringUtils.isNotEmpty(address), "address", address)
                        .like(StringUtils.isNotEmpty(remark), "remark", remark)
                        .like(StringUtils.isNotEmpty(extattr), "extattr", extattr)
                        .eq(gmtCreated != null, "gmt_created", gmtCreated)
                        .eq(gmtModified != null, "gmt_modified", gmtModified)
                        .like(StringUtils.isNotEmpty(gmtAuthor), "gmt_author", gmtAuthor)
        );

        return new PageUtils(page);
    }

}
