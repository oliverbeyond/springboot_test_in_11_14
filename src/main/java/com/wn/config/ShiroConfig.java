/*
package com.wn.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("Manager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器
        //  登入拦截
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/add", "authc");
        map.put("/user/updata", "authc");
        //  map.put("/user/*","anthc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置登入的请求
        shiroFilterFactoryBean.setLoginUrl("/tologin");

        return shiroFilterFactoryBean;


    }


    @Bean(name = "Manager")
    //DefalutWebSecurityManger
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm") UserRealm userRealm) {
        DefaultWebSecurityManager Manager = new DefaultWebSecurityManager();
        //关联realm中间商
        Manager.setRealm(userRealm);
        return Manager;
    }

    //Realm  1.
    @Bean
    public UserRealm realm() {
        return new UserRealm();
    }
}
*/
