package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.vo.UserInformationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Mapper
public interface UserMapper extends BaseMapper<TbUser> {

    /**
     * @author zml
     *
     * @param null
     * @return
     * 返回学生列表
     *
     */
    List<TbUser> getListStudent(Page<TbUser> page, Map<String, Object> params);
   /**
    * @author zml
    *
    * @param null
    * @return
    * 返回教师或者其他用户
    *
    */
    List<TbUser> getListTeacher(Page<TbUser> page, Map<String, Object> params);
   /**
    * @author zml
    *
    * @param null
    * @return
    *
    * 返回用户个人信息
    */
    UserInformationVo getUserInformation(String id);
    /**
     * @author zml
     *
     * @param null
     * @return
     * 找回密码
     *
     */
    TbUser isExitEmail(String email);
}
