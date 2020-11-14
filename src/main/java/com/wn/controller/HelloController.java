package com.wn.controller;

import com.wn.mapper.UserMapper;
import com.wn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    User user;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("hello")
    public String hello(){

        return "hello,world!"+user;
    }

    @RequestMapping("update")
    public void update(Integer userid){
        userMapper.updateUser(userid);
    }
}
