package com.springboot.mybatisplus.service;



import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.DsfUserEntity;
import com.springboot.mybatisplus.util.PageUtils;

import java.util.List;
import java.util.Map;


/**
 * 用户表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:50:54
 */
public interface DsfUserService extends IService<DsfUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId 用户ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username 用户名
     * @return
     */
    DsfUserEntity queryByUserName(String username);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(DsfUserEntity user);

    /**
     * 修改用户
     *
     * @param user
     */
    void update(DsfUserEntity user);

    /**
     * 删除用户
     *
     * @param userIds 用户ids
     */
    void deleteBatch(Long[] userIds);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param password    原密码
     * @param newPassword 新密码
     */
    boolean updatePassword(Long userId, String password, String newPassword);

    /**
     * 重设密码
     *
     * @param userId       用户ID
     * @param initPassword 初始密码
     */
    boolean resetPassword(Long userId, String initPassword);

    /**
     * 修改状态
     *
     * @param userId 用户ID
     */
    void updateStatus(Long userId, String status);

    /**
     * 查询用户列表
     */
    PageUtils<DsfUserEntity> queryList(Map<String, Object> map);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    DsfUserEntity queryObject(Long userId);

    /**
     * 查询通讯录用户列表
     *
     * @param map 查询条件
     * @return
     */
    PageUtils<DsfUserEntity> queryAddressList(Map<String, Object> map);

    /**
     * 根据中文名称查询用户列表
     *
     * @param map
     * @return
     */
    PageUtils<DsfUserEntity> queryListByName(Long userId, Map<String, Object> map);

    /**
     * 根据中文名称查询通讯录用户列表
     *
     * @param userId
     * @param map
     * @return
     */
    PageUtils<DsfUserEntity> queryAddressListByName(Long userId, Map<String, Object> map);

    int selectCountbyDeptId(Long id);

    /**
     * 获取用户详细信息
     *
     * @param uids
     * @return
     */
    List<DsfUserEntity> queryUserList(List<Long> uids);
}

