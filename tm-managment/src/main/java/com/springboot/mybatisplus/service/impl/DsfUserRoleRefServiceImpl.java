package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.entity.DsfUserRoleRefEntity;
import com.springboot.mybatisplus.service.DsfUserRoleRefService;
import com.springboot.mybatisplus.util.PageUtils;
import com.springboot.mybatisplus.util.query.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service("dsfUserRoleRefService")
public class DsfUserRoleRefServiceImpl extends ServiceImpl<DsfUserRoleRefDao, DsfUserRoleRefEntity> implements DsfUserRoleRefService {

    @Autowired
    private DsfMenuDao dsfMenuDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Date gmtCreated = (Date) params.get("gmtCreated");
        Date gmtModified = (Date) params.get("gmtModified");
        String gmtAuthor = (String) params.get("gmtAuthor");
        Page<DsfUserRoleRefEntity> page = this.selectPage(
                new Query<DsfUserRoleRefEntity>(params).getPage(),
                new EntityWrapper<DsfUserRoleRefEntity>()
                        .eq(gmtCreated != null, "gmt_created", gmtCreated)
                        .eq(gmtModified != null, "gmt_modified", gmtModified)
                        .like(StringUtils.isNotEmpty(gmtAuthor), "gmt_author", gmtAuthor)
        );

        return new PageUtils(page);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return baseMapper.deleteBatch(ids);
    }

    /**
     * 保存与更新用户关系表
     *
     * @param userId
     * @param gmtauthor
     * @param roleIdList
     */
    @Override
    public void saveOrUpdate(Long userId, String gmtauthor, List<Long> roleIdList) {
        //先删除用户与角色关系
        this.deleteByMap(new MapUtils().put("user_id", userId));

        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }

        //保存用户与角色关系
        List<DsfUserRoleRefEntity> list = new ArrayList<>(roleIdList.size());
        for (Long roleId : roleIdList) {
            DsfUserRoleRefEntity dsfUserRoleRefEntity = new DsfUserRoleRefEntity();
            dsfUserRoleRefEntity.setUserId(userId);
            dsfUserRoleRefEntity.setRoleId(roleId);
            dsfUserRoleRefEntity.setGmtAuthor(gmtauthor);
            list.add(dsfUserRoleRefEntity);
        }
        this.insertBatch(list);
    }


    /**
     * 根据用户ID，获取角色ID列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return baseMapper.queryRoleIdList(userId);
    }

    /**
     * 角色授权给对应的用户
     *
     * @param uids
     * @param rid
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void roleAuthorize(String username, List<Long> uids, Long rid) {
        if (rid == null || (uids == null && uids.size() == 0)) {
            return;
        }
        List<DsfUserRoleRefEntity> datas = new ArrayList<>();

        //根据角色ID查询对应的用户角色信息
        List<DsfUserRoleRefEntity> results = baseMapper.selectList(new EntityWrapper<DsfUserRoleRefEntity>().eq("role_id", rid));

        for (Long uid : uids) {
            //过滤已经存在的用户角色关系
            if (isExitUserRole(uid, results)) {
                continue;
            }
            DsfUserRoleRefEntity ur = new DsfUserRoleRefEntity();
            ur.setRoleId(rid);
            ur.setUserId(uid);
            ur.setGmtAuthor(username);
            ur.setGmtCreated(new Date());
            datas.add(ur);
        }

        if (datas.size() > 0) {
            this.insertBatch(datas);
        }

    }

    //判断对应的uid是否存在用户角色表关系中
    private boolean isExitUserRole(Long uid, List<DsfUserRoleRefEntity> results) {
        boolean temp = false;
        if (results != null && results.size() > 0) {
            for (DsfUserRoleRefEntity result : results) {
                if (uid.equals(result.getUserId())) {
                    temp = true;
                    break;
                }
            }
        }

        return temp;
    }

    /**
     * 删除角色授权对应的用户
     *
     * @param username 当前登录帐号
     * @param uids     用户id数组
     * @param rid      角色id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delAuthorize(String username, List<Long> uids, Long rid) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("uids", uids);
        paramMap.put("rid", rid);

        baseMapper.delAuthorize(paramMap);
    }

    /**
     * 根据用户ID，获取角色列表对象
     */
    @Override
    public List<DsfRoleEntity> queryRolesByUserId(Long userId) {
        List<DsfRoleEntity> dsfRoleEntityList = baseMapper.queryRolesByUserId(userId);
        if (dsfRoleEntityList != null && dsfRoleEntityList.size() > 0) {
            for (DsfRoleEntity dsfrole : dsfRoleEntityList) {
                //查询角色对应的菜单
                List<Long> menuIdList = dsfMenuDao.queryMenuIdList(dsfrole.getId());
                dsfrole.setMenuIdList(menuIdList);
            }
        }
        return dsfRoleEntityList;
    }
}
