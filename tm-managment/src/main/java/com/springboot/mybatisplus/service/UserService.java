package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.vo.UserInformationVo;

import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
public interface UserService extends IService<TbUser> {

    /**
     * @author zml
     *
     * @param null
     * @return
     * 查询学生列表
     *
     */
    PageObject<TbUser> getStudentPage(Map<String, Object> params);
    /**
     * @author zml
     *
     * @param null
     * @return
     * 查询其他角色列表
     *
     */
    PageObject<TbUser> getOtherUserPage(Map<String, Object> params);
    /**
     * @param null
     * @return 增加
     * @author zml
     */
    void save(TbUser tbUser);

    /**
     * @param null
     * @return 更新
     * @author zml
     */
    void update(TbUser tbUser);

    /**
     * @param null
     * @return
     * @author zml
     * 逻辑删除
     */
    void delete(TbUser tbUser);

    /**
     * @param null
     * @return 查找用户个人信息
     * @author zml
     */
    UserInformationVo selectUserByid(String id);

    /**
     * @author zml
     *
     * @param null
     * @return
     *
     * 是否存在这个邮箱账号
     */
    boolean isExitUser(String eamil);
}
