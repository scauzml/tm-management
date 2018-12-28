package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.DsfRoleEntity;
import com.springboot.mybatisplus.vo.RoleAuthorizeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:56:35
 */
@Mapper
public interface DsfRoleDao extends BaseMapper<DsfRoleEntity> {
    List<Long> queryRoleIdList(String gmtAuthor);

    /**
     * 根据角色Id/用户名/姓名查询角色授权的用户信息
     *
     * @param params
     * @return
     */
    List<RoleAuthorizeVo> queryAuthorizeUser(Map<String, Object> params);

    /**
     * 根据角色Id/用户名/姓名查询角色授权的用户总记录数
     *
     * @param map
     * @return
     */
    int queryAuthorizeUserTotal(Map<String, Object> map);
}
