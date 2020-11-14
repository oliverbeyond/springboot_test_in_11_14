package com.wn.controller;

import com.wn.mapper.UserMapper;
import com.wn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class JspController {
    @Autowired
    UserMapper userMapper;


    /*ajax登录请求*/
    @RequestMapping("ajaxlogin")
    public @ResponseBody
    Object queryUser(HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<String, String> res = new HashMap();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.login(username, password);
        if (user != null) {
            res.put("stateCode", "1");
            session.setAttribute("usermessage", user.getUsername());
            return res;
        } else {
            res.put("stateCode", "0");
            return res;
        }
    }

    /*登录成功,带值跳转*/
    @RequestMapping("successlogin")
    public String successlogin(HttpSession session, Model model) {
        String usermessage = (String) session.getAttribute("usermessage");
        System.out.println(usermessage);
        if (usermessage == null) {
            return "redirect:index.jsp";
        } else {
            model.addAttribute("msg", usermessage);
            return "home1";
        }
    }

    /*form登录请求*/
    @RequestMapping("userlogin")
    public String login(HttpServletRequest request, Model model, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userMapper.login(username, password);
        if (user != null) {
            model.addAttribute("msg", user);
            session.setAttribute("usermessage", user.getUsername());
            System.out.println(user);
            return "home1";
        } else {
            /*如果那个默认添加的页面不合适,加一个重定向就好*/
            return "redirect:error.jsp";
        }
    }

}