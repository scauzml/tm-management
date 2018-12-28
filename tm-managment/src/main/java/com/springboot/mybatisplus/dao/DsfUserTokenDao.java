package com.springboot.mybatisplus.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.DsfUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface DsfUserTokenDao extends BaseMapper<DsfUserTokenEntity> {

    DsfUserTokenEntity queryByToken(String token);

}
