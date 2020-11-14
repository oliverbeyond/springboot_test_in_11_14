package com.wn.config;

import com.wn.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*Configuration注解相当于beans标签*/
@Configuration
public class UserConfig {
    /*这样就可以在别的类注入user对象了*/
    @Bean(name = "user")
    public User getUser(){
        User user = new User();
        return user;
    }
}
