package com.example.shiro2;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig2 {
    @Bean
    MyRealm2 myRealm2() {
        return new MyRealm2();
    }

    @Bean
    DefaultWebSecurityManager securityManager2() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm2());
        return manager;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition2() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/doLogin2", "anon");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}
