package com.springboot.mybatisplus.service;


import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.DsfRoleEntity;
import com.springboot.mybatisplus.util.PageUtils;
import com.springboot.mybatisplus.vo.RoleAuthorizeVo;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:56:35
 */
public interface DsfRoleService extends IService<DsfRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateRole(DsfRoleEntity dsfRole, Long userId);

    void save(DsfRoleEntity dsfRole, Long userId);

    void deleteBatch(Long[] ids);

    /**
     * 根据用户名查询创建的角色ID列表
     */
    List<Long> queryRoleIdList(String gmtAuthor);

    /**
     * 根据角色Id/用户名/姓名查询角色授权的用户信息
     *
     * @param params
     * @return
     */
    List<RoleAuthorizeVo> queryAuthorizeUser(Map<String, Object> params);

    /**
     * 根据角色Id/用户名/姓名查询角色授权的用户的总记录数
     *
     * @param map
     * @return
     */
    int queryAuthorizeUserTotal(Map<String, Object> map);

    /**
     * 根据名称匹配查询角色是否有记录
     *
     * @param roleName
     * @return
     */
    int queryRoleCount(String roleName);


}

