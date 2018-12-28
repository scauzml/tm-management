package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.DsfUserDao;
import com.springboot.mybatisplus.entity.DsfUserEntity;
import com.springboot.mybatisplus.service.DsfPersonService;
import com.springboot.mybatisplus.service.DsfRoleService;
import com.springboot.mybatisplus.service.DsfUserRoleRefService;
import com.springboot.mybatisplus.service.DsfUserService;
import com.springboot.mybatisplus.util.PageUtils;
import com.springboot.mybatisplus.util.query.Query;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("dsfUserService")
public class DsfUserServiceImpl extends ServiceImpl<DsfUserDao, DsfUserEntity> implements DsfUserService {

//	@Value("${do1.authorize.initPassword:do1@2018}")
//	private String initPassword;

    @Autowired
    private DsfPersonService dsfPersonService;

    @Autowired
    private DsfRoleService dsfRoleService;

    @Autowired
    private DsfUserRoleRefService dsfUserRoleRefService;

    @Autowired
    private DsfUserResourcePersonService dsfUserResourcePersonService;

    @Autowired
    private DsfUserManageService dsfUserManageService;

    @Autowired
    private DsfUserAddressbookService dsfUserAddressbookService;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userName = (String) params.get("userName");
        String password = (String) params.get("password");
        String mobile = (String) params.get("mobile");
        String idCard = (String) params.get("idCard");
        String status = (String) params.get("status");
        Date gmtCreated = (Date) params.get("gmtCreated");
        Date gmtModified = (Date) params.get("gmtModified");
        String gmtAuthor = (String) params.get("gmtAuthor");
        Page<DsfUserEntity> page = this.selectPage(
                new Query<DsfUserEntity>(params).getPage(),
                new EntityWrapper<DsfUserEntity>()
                        .like(StringUtils.isNotEmpty(userName), "user_name", userName)
                        .like(StringUtils.isNotEmpty(password), "password", password)
                        .like(StringUtils.isNotEmpty(mobile), "mobile", mobile)
                        .like(StringUtils.isNotEmpty(idCard), "id_card", idCard)
                        .like(StringUtils.isNotEmpty(status), "status", status)
                        .eq(gmtCreated != null, "gmt_created", gmtCreated)
                        .eq(gmtModified != null, "gmt_modified", gmtModified)
                        .like(StringUtils.isNotEmpty(gmtAuthor), "gmt_author", gmtAuthor)
        );

        return new PageUtils(page);
    }


    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<String> queryAllPerms(Long userId) {
        return baseMapper.queryAllPerms(userId);
    }

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }

    /**
     * 根据用户名，查询系统用户
     *
     * @param username 用户名
     * @return
     */
    @Override
    public DsfUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    @Transactional
    public void save(DsfUserEntity user) {

        //检查用户名是否已存在
        int usercount = this.selectCount(new EntityWrapper<DsfUserEntity>().eq(user.getUserName() != null, "user_name", user.getUserName()));
        if (usercount > 0) {
            throw new RestException("该帐号已存在,请重新命名。");
        }

        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        user.setPersonName(user.getDsfPersonEntity().getPersonName());
        this.insert(user);

        //插入人员表
        DsfPersonEntity dsfPersonEntity = user.getDsfPersonEntity();
        dsfPersonEntity.setTitle(user.getUsertitle());
        dsfPersonService.insert(dsfPersonEntity);

        //插入关系表
        DsfUserPersonRefEntity dsfUserPersonRefEntity = new DsfUserPersonRefEntity();
        dsfUserPersonRefEntity.setUserId(user.getUserId());
        dsfUserPersonRefEntity.setPersonId(dsfPersonEntity.getPersonId());
        dsfUserPersonRefService.insert(dsfUserPersonRefEntity);

        //检查角色是否越权
//		checkRole(user);
//
//		//保存用户与角色关系
//		dsfUserRoleRefService.saveOrUpdate(user.getUserId(),user.getGmtAuthor(), user.getRoleIdList());

        //保存通讯录关系
        dsfUserResourcePersonService.saveOrUpdate(user.getUserId(), user.getResouresPersonId());

        //保存部门数据权限与读写权限
        dsfUserManageService.saveOrUpdate(user.getUserId(), user.getUserManageEntityList());

        //保存通讯录管理权限
        dsfUserAddressbookService.saveOrUpdate(user.getUserId(), user.getDsfUserAddressbookEntityList());
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    @Transactional
    public void update(DsfUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        user.setPersonName(user.getDsfPersonEntity().getPersonName());
        this.updateById(user);

        //更新人员信息
        dsfPersonService.updateById(user.getDsfPersonEntity());

        //检查角色是否越权
//		checkRole(user);
//
//		//保存用户与角色关系
//		dsfUserRoleRefService.saveOrUpdate(user.getUserId(),user.getGmtAuthor(), user.getRoleIdList());

        //保存通讯录关系
        dsfUserResourcePersonService.saveOrUpdate(user.getUserId(), user.getResouresPersonId());

        //保存部门数据权限与读写权限
        dsfUserManageService.saveOrUpdate(user.getUserId(), user.getUserManageEntityList());

        //保存通讯录管理权限
        dsfUserAddressbookService.saveOrUpdate(user.getUserId(), user.getDsfUserAddressbookEntityList());

    }

    /**
     * 批量删除
     *
     * @param userId 用户ids
     */
    @Override
    public void deleteBatch(Long[] userId) {
        baseMapper.deleteBatch(userId);
    }

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param password    原密码
     * @param newPassword 新密码
     */
    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        DsfUserEntity userEntity = new DsfUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<DsfUserEntity>().eq("user_id", userId).eq("password", password));
    }

    /**
     * 重设密码
     *
     * @param userId 用户ID
     */
    @Override
    public boolean resetPassword(Long userId, String initPassword) {
        DsfUserEntity userEntity = new DsfUserEntity();
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        userEntity.setPassword(new Sha256Hash(new Md5Hash(initPassword).toHex(), salt).toHex());
        userEntity.setSalt(salt);
        return this.update(userEntity,
                new EntityWrapper<DsfUserEntity>().eq("user_id", userId));
    }

    /**
     * 修改状态
     *
     * @param userId 用户ID
     */
    @Override
    public void updateStatus(Long userId, String status) {
        DsfUserEntity userEntity = new DsfUserEntity();
        userEntity.setStatus(status);
        this.update(userEntity,
                new EntityWrapper<DsfUserEntity>().eq("user_id", userId));
    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(DsfUserEntity user) {

        if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0) {
            return;
        }
        DsfUserEntity dsfUserEntity = this.queryByUserName(user.getGmtAuthor());
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (dsfUserEntity.getUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户创建的角色列表
        List<Long> roleIdList = dsfRoleService.queryRoleIdList(user.getGmtAuthor());

        //判断是否越权
        if (!roleIdList.containsAll(user.getRoleIdList())) {
            throw new RestException("新增用户所选角色，不是本人创建");
        }
    }

    /**
     * 查询用户列表
     *
     * @param map 参数
     * @return
     */
    @Override
    public PageUtils<DsfUserEntity> queryList(Map<String, Object> map) {
        Page<DsfUserEntity> page = ((Query) map).getPage();
        List<DsfUserEntity> list = baseMapper.queryList(page, map);
        page.setRecords(list);
        return new PageUtils(page);
    }


    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public DsfUserEntity queryObject(Long userId) {
        DsfUserEntity dsfUserEntity = baseMapper.queryObject(userId);

        if (dsfUserEntity != null) {

            //获取用户所属的角色列表
			/*List<Long> roleIdList = dsfUserRoleRefService.queryRoleIdList(userId);
			dsfUserEntity.setRoleIdList(roleIdList);*/
            List<DsfRoleEntity> roles = dsfUserRoleRefService.queryRolesByUserId(userId);
            dsfUserEntity.setRoles(roles);

            //获取用户所属门部权限关系列表
            List<DsfUserManageEntity> dsfUserManageEntityList = dsfUserManageService.queryUserManageList(userId);
            dsfUserEntity.setUserManageEntityList(dsfUserManageEntityList);

            //通讯录管理权限关系表
			/*Map<String, Object> map=new HashMap<>();
			map.put("user_id",userId);
			List<DsfUserAddressbookEntity> dsfUserAddressbookEntityList=dsfUserAddressbookService.selectByMap(map);*/
            List<DsfUserAddressbookEntity> dsfUserAddressbookEntityList = dsfUserAddressbookService.queryUserAddressbookByUserId(userId);
            dsfUserEntity.setDsfUserAddressbookEntityList(dsfUserAddressbookEntityList);
        }

        return dsfUserEntity;
    }


    @Override
    public List<DsfUserEntity> queryUserList(List<Long> uids) {
        return baseMapper.queryUserList(uids);
    }
}
