package com.wn.controller;

import com.wn.mapper.UserMapper;
import com.wn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    /*admin查看所有用户*/
    @RequestMapping("/user")
    public String selectUser(Model model){
        List<User> list = userMapper.selectUser();
        model.addAttribute("user",list);
        return "admin_user";
    }
}
