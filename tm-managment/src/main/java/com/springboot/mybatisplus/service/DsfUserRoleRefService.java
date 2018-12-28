package com.springboot.mybatisplus.service;


import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.DsfRoleEntity;
import com.springboot.mybatisplus.entity.DsfUserRoleRefEntity;
import com.springboot.mybatisplus.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关系表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 10:49:05
 */
public interface DsfUserRoleRefService extends IService<DsfUserRoleRefEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据角色ID删除用户角色关系
     *
     * @param roleIds
     * @return
     */
    int deleteBatch(Long[] roleIds);

    /**
     * 保存与更新用户关系表
     *
     * @param userId     用户iD
     * @param gmtauthor  创建人
     * @param roleIdList 角色列表
     */
    void saveOrUpdate(Long userId, String gmtauthor, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    /**
     * 根据用户ID，获取角色列表对象
     */
    List<DsfRoleEntity> queryRolesByUserId(Long userId);

    /**
     * 角色授权给对应的用户
     *
     * @param username 当前登录帐号
     * @param uids     用户id数组
     * @param rid      角色id
     */
    void roleAuthorize(String username, List<Long> uids, Long rid);

    /**
     * 删除角色授权对应的用户
     *
     * @param username 当前登录帐号
     * @param uids     用户id数组
     * @param rid      角色id
     */
    void delAuthorize(String username, List<Long> uids, Long rid);
}

