package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.DsfRoleEntity;
import com.springboot.mybatisplus.entity.DsfUserRoleRefEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关系表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 10:49:05
 */
@Mapper
public interface DsfUserRoleRefDao extends BaseMapper<DsfUserRoleRefEntity> {
    int deleteBatch(Long[] ids);

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void delAuthorize(Map<String, Object> paramMap);

    /**
     * 根据用户ID，获取角色列表对象
     *
     * @param userId
     * @return
     */
    List<DsfRoleEntity> queryRolesByUserId(Long userId);
}
