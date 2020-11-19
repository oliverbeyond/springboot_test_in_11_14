package com.wn.controller;

import com.wn.mapper.UserMapper;
import com.wn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.util.DigestUtils;



import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
@Controller
public class JspController {
    @Autowired
    UserMapper userMapper;
    private static String charArray = "0";


    /*ajax登录请求*/
    @RequestMapping("ajaxlogin")
    /*加上@Responsebody后，会直接返回json数据*/
    public @ResponseBody
    Object queryUser(HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<String, String> res = new HashMap();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");
        String passwored_sult = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("我输入的验证码是:" + captcha);
        User user = userMapper.login(username, passwored_sult);
        if (!captcha.equals(request.getSession().getAttribute("captcha"))) {
            res.put("stateCode", "-1");
            return res;
        } else {
            if (user != null) {
                res.put("stateCode", "1");
                session.setAttribute("usermessage", user.getUsername());
                return res;
            } else {
                res.put("stateCode", "0");
                return res;
            }
        }
    }

    /*ajax注册请求*/
    @RequestMapping("ajaxregister")
    /*加上@Responsebody后，会直接返回json数据*/
    public @ResponseBody
    Object register(HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<String, String> res = new HashMap();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userMapper.register(username);
        if (user != null) {
            res.put("stateCode", "0");
            return res;
        } else {
            String passwored_sult = DigestUtils.md5DigestAsHex(password.getBytes());
            userMapper.insert(username,passwored_sult);
            res.put("stateCode", "1");
            return res;
        }
    }


    /*ajax方式登录成功,带值跳转*/
    @RequestMapping("successlogin")
    public String successlogin(HttpSession session, Model model) {
        String usermessage = (String) session.getAttribute("usermessage");
        System.out.println(usermessage);
        if (usermessage == null) {
            return "redirect:index.jsp";
        } else {
            model.addAttribute("msg", usermessage);
            return "admin_main";
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
            return "admin_main";
        } else {
            /*如果那个默认添加的页面不合适,加一个重定向就好*/
            return "redirect:error.jsp";
        }
    }

    /*退出登录请求*/
    @RequestMapping("quit")
    public String login() {
        return "redirect:index.jsp";
    }

    /*注册请求*/
    @RequestMapping("register")
    public String register() {
        return "redirect:register.jsp";
    }

    /*登录的验证码,这个不用返回值!直接请求完了写进输出流就输出了!*/
    @RequestMapping("/captcha.png")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = bufferedImage.getGraphics();
        //默认情况下的画布是黑色，接下来将画布填充为白色
        graphics.setColor(Color.WHITE); //配置画笔颜色
        //填充一个方块
        graphics.fillRect(0, 0, 90, 30);

        //绘制第一个数字

        Random random = new Random();
        int length = charArray.length();


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            //获取一个随机下标
            int nextInt = random.nextInt(length);

            //随机获取一个数字
            char charAt = charArray.charAt(nextInt);
            stringBuilder.append(charAt);
            //在画布上绘制一个数字
            int r = random.nextInt(200);
            int g = random.nextInt(200);
            int b = random.nextInt(200);

            graphics.drawLine(5, 5, 70, 25);
            graphics.setColor(new Color(r, g, b));
            graphics.drawString(charAt + "", 5 + i * 20, 20);
        }

        //将验证码存入session中
        request.getSession().setAttribute("captcha", stringBuilder.toString());
        System.out.println("本次的验证码是:" + stringBuilder.toString());

        //将上面的这个图片存入流中
        ImageIO.write(bufferedImage, "png", response.getOutputStream());
    }
}