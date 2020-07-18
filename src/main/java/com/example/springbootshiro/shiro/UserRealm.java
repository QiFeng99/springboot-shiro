package com.example.springbootshiro.shiro;


import com.example.springbootshiro.po.User;
import com.example.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义realm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑!");

        //授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        info.addStringPermission(principal.getPerms());
        return info;

    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        /**
         * 判断数据库的用户名和密码
         *
         */
//        String name="fq";
//        String password="123";


        //获取用户输入数据
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        List<User> userList=userService.findName(token.getUsername());

        if(userList.size()<=0){
            return null;
        }
        return new SimpleAuthenticationInfo(userList.get(0),userList.get(0).getPassword(),"");
    }
}
