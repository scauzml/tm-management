package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.DsfUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:50:54
 */
@Mapper
public interface DsfUserDao extends BaseMapper<DsfUserEntity> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return
     */
    List<String> queryAllPerms(@Param("userId") Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId 用户ID
     * @return
     */
    List<Long> queryAllMenuId(@Param("userId") Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username 用户名
     * @return
     */
    DsfUserEntity queryByUserName(String username);

    /**
     * 根据用户id，查询系统用户
     *
     * @param userId 用户ID
     * @return
     */
    DsfUserEntity queryObject(Long userId);

    /**
     * 查询用户的所有权限数据过滤
     *
     * @param page 分页条件
     * @param map  参数
     * @return
     */
    List<DsfUserEntity> queryList(Page<DsfUserEntity> page, Map<String, Object> map);


    /**
     * 批量删除
     *
     * @param userId 用户ids
     */
    void deleteBatch(Long[] userId);

    /**
     * 查询通讯录用户的所有权限数据过滤
     *
     * @param page 分页条件
     * @param map  参数
     * @return
     */
    List<DsfUserEntity> queryAddressList(Page<DsfUserEntity> page, Map<String, Object> map);


    /**
     * 根据中文名查询用户信息
     *
     * @param page
     * @param map
     * @return
     */
    List<DsfUserEntity> queryListByName(Page<DsfUserEntity> page, Map<String, Object> map);

    /**
     * 根据中文名查询通讯录用户信息
     *
     * @param page
     * @param map
     * @return
     */
    List<DsfUserEntity> queryAddressListByName(Page<DsfUserEntity> page, Map<String, Object> map);

    /**
     * 获取用户详细信息
     *
     * @param paramMap 存储id集合的Map
     * @return
     */
    List<DsfUserEntity> queryUserList(List<Long> uids);

}
