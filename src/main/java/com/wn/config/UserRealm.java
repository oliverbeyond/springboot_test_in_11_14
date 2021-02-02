/*
package com.wn.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//自定义的userRealm 需要继承 AuthorizingRealm
public class UserRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");
        //数据库里面取用户名，密码
        String name = "root";
        String password = "123456";
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        if (!name.equals(usertoken.getUsername())) {
            return null;
        }
        //密码认证不让你做 shiro做
        return new SimpleAuthenticationInfo("", password, "");

    }
}
*/
