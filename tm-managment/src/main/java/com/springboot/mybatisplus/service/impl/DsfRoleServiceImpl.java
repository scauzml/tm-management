package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.DsfRoleDao;
import com.springboot.mybatisplus.entity.DsfRoleEntity;
import com.springboot.mybatisplus.exception.RestException;
import com.springboot.mybatisplus.service.DsfRoleService;
import com.springboot.mybatisplus.service.DsfUserRoleRefService;
import com.springboot.mybatisplus.util.PageUtils;
import com.springboot.mybatisplus.util.SqlUtil;
import com.springboot.mybatisplus.util.query.Query;
import com.springboot.mybatisplus.vo.RoleAuthorizeVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("dsfRoleService")
public class DsfRoleServiceImpl extends ServiceImpl<DsfRoleDao, DsfRoleEntity> implements DsfRoleService {

    @Autowired
    private DsfUserRoleRefService dsfUserRoleRefService;
/*

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String) params.get("roleName");
        String gmtAuthor = (String) params.get("gmtAuthor");
        Page<DsfRoleEntity> page = this.selectPage(
                new Query<DsfRoleEntity>(params).getPage(),
                new EntityWrapper<DsfRoleEntity>()
                        .like(StringUtils.isNotEmpty(roleName), "role_name", SqlUtil.repalceWildcard(roleName))
                        .eq(StringUtils.isNotEmpty(gmtAuthor), "gmt_author", gmtAuthor)
        );

        PageUtils<DsfRoleEntity> result = new PageUtils(page);

        List<DsfRoleEntity> roles = result.getList();
        if (roles != null && roles.size() > 0) {
            for (DsfRoleEntity role : roles) {
                List<Long> menuIds = dsfRoleMenuRefService.queryMenuIdsByRoleId(role.getId());
                role.setMenuIdList(menuIds);
            }
        }

        return result;
    }
*/


    /*@Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DsfRoleEntity dsfRole, Long userId) {

        List<DsfRoleEntity> roles = this.selectList(new EntityWrapper<DsfRoleEntity>()
                .eq("role_name", dsfRole.getRoleName())
                .eq("gmt_author", dsfRole.getGmtAuthor()));
        if (roles != null && roles.size() > 0) {
            throw new RestException("该角色名称【" + dsfRole.getRoleName() + "】已被创建!");
        }

        Date date = new Date();
        dsfRole.setGmtCreated(date);
        dsfRole.setGmtModified(date);
        this.insert(dsfRole);

    }*/

   /* @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(DsfRoleEntity dsfRole, Long userId) {

        DsfRoleEntity dsfRoleEntity = this.selectById(dsfRole.getId());
        if (!dsfRole.getRoleName().equals(dsfRoleEntity.getRoleName())) {
            List<DsfRoleEntity> roles = this.selectList(new EntityWrapper<DsfRoleEntity>()
                    .eq("role_name", dsfRole.getRoleName())
                    .eq("gmt_author", dsfRole.getGmtAuthor()));
            if (roles != null && roles.size() > 0) {
                throw new RestException("该角色名称【" + dsfRole.getRoleName() + "】已被创建!");
            }
        }

        Date day = new Date();
        dsfRole.setGmtModified(day);
        dsfRole.setGmtCreated(day);
        this.updateAllColumnById(dsfRole);

    }*/






    @Override
    public List<Long> queryRoleIdList(String gmtAuthor) {
        return baseMapper.queryRoleIdList(gmtAuthor);
    }


    @Override
    public List<RoleAuthorizeVo> queryAuthorizeUser(Map<String, Object> params) {
        return baseMapper.queryAuthorizeUser(params);
    }


    @Override
    public int queryAuthorizeUserTotal(Map<String, Object> map) {
        return baseMapper.queryAuthorizeUserTotal(map);
    }


    @Override
    public int queryRoleCount(String roleName) {
        return baseMapper.selectCount(new EntityWrapper<DsfRoleEntity>().eq("role_name", roleName));
    }


}
