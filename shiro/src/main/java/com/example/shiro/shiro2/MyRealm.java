package com.example.shiro.shiro2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        if(!"lam".equals(username)){
            throw new UnknownAccountException("账户不存在！");
        }
        return new SimpleAuthenticationInfo(username,"123",getName());
    }
}
