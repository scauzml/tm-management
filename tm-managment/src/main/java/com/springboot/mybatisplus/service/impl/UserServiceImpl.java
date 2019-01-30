package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.TbUserMapper;
import com.springboot.mybatisplus.dao.UserMapper;
import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.service.ITbUserService;
import com.springboot.mybatisplus.service.UserService;
import com.springboot.mybatisplus.util.id.DistributedIdGenerator;
import com.springboot.mybatisplus.util.query.Query;
import com.springboot.mybatisplus.vo.UserInformationVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TbUser> implements UserService {

    @Override
    public PageObject<TbUser> getStudentPage(Map<String, Object> params) {
        Page<TbUser> page = new Query<TbUser>(params).getPage();

        List<TbUser> list = baseMapper.getListStudent(page, params);
        page.setRecords(list);
        return new PageObject<TbUser>(page);
    }

    @Override
    public PageObject<TbUser> getOtherUserPage(Map<String, Object> params) {
        Page<TbUser> page = new Query<TbUser>(params).getPage();

        List<TbUser> list = baseMapper.getListTeacher(page, params);
        page.setRecords(list);
        return new PageObject<TbUser>(page);
    }
    /**
     * @author zml
     *
     * @param null
     * @return
     * 保存用户id
     *
     */
    @Override
    public void save(TbUser tbUser) {
        String id = DistributedIdGenerator.generateId().toString();
        tbUser.setId(id);
         baseMapper.insert(tbUser);
    }

    @Override
    public void update(TbUser tbUser) {
        baseMapper.updateById(tbUser);
    }

    @Override
    public void delete(TbUser tbUser) {
        tbUser.setIsDel(1);
        baseMapper.updateById(tbUser);
    }

    @Override
    public UserInformationVo selectUserByid(String id) {
        UserInformationVo userInformationVo=baseMapper.getUserInformation(id);
        return userInformationVo;
    }

    /**
     * @author zml
     *
     * @param null
     * @return
     * 判断是否存在当前用户
     *
     */
    @Override
    public boolean isExitUser(String eamil) {

        TbUser tbUser = baseMapper.isExitEmail(eamil);
        return null==tbUser?false:true;
    }
}
