package com.springboot.mybatisplus.config;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.springboot.mybatisplus.entity.*;
import com.springboot.mybatisplus.service.SecUserRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author{张明亮} 2018/12/23 21:46
 */
// 验证，权限添加
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SecUserRoleService secUserRoleService;

//角色的权限的添加，
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //String name=(String) principalCollection.getPrimaryPrincipal();
        User user=(User) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        Set<String> allRoles=new HashSet<>();
        //保存所有权限名
        Set<String> allPermissions=new HashSet<>();
        //查询对应的角色

        EntityWrapper<SecUserRole> ew=new EntityWrapper<>();
        ew.eq("userid", user.getId());
        List<SecUserRole> secUserRoles = secUserRoleService.selectList(ew);

        //List<SecUserRole> secUserRoles = (new SecUserRole()).selectList(new EntityWrapper<SecUserRole>().eq("userid", user.getId()));
       System.out.println(secUserRoles.size());
        for (SecUserRole userRole:secUserRoles) {
            Role role = new Role();
            role.setId(userRole.getRoleid());
            role = role.selectById();
            allRoles.add(role.getRoleName());

            //查询所有权限
            List<Permission> permissions = new ArrayList<>();

            List<SecRolePermission> rolePermissions = new SecRolePermission().selectList(new EntityWrapper().eq("role", role.getId()));
            for (SecRolePermission rolePermission:rolePermissions) {
                Permission permission = new Permission();
                permission.setId(rolePermission.getPm());
                permission = permission.selectById();
                allPermissions.add(permission.getPermission());
            }
        }
        //添加角色
        simpleAuthorizationInfo.addRoles(allRoles);
        simpleAuthorizationInfo.addStringPermissions(allPermissions);


        System.out.println(user);

        return simpleAuthorizationInfo;

    }
    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1、登录认证的方法需要先执行，需要用他来判断登录的用户信息是否合法
        String username = (String) token.getPrincipal();    // 取得用户名
        // 需要通过用户名取得用户的完整信息，利用业务层操作
        User user=null;
        try {
            user = new User().selectOne(new EntityWrapper().eq("name",username));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException("该用户名称不存在！");
        } else {    // 进行密码的验证处理
            String password =new String((char[]) token.getCredentials()).trim();
            String psw=String.valueOf(user.getPassword()).trim();
            // 将数据库中的密码与输入的密码进行比较，这样就可以确定当前用户是否可以正常登录
            if (psw.equals(password)) {    // 密码正确

                AuthenticationInfo auth = new SimpleAuthenticationInfo(user, password, getName());
                return auth;
            } else {
                throw new IncorrectCredentialsException("密码错误！");
            }
        }
    }

}
