package com.wn.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Controller
public class Test1 {

    @Autowired
    JavaMailSender javaMailSender;
    @RequestMapping("sendmail")
    public void contextLoads(HttpServletRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("17865565575@163.com");
        message.setTo("wn97119@qq.com");
        message.setCc("wn97119@qq.com");
        message.setBcc("wn97119@qq.com");
        message.setSentDate(new Date());
        message.setText("test");
        javaMailSender.send(message);
    }

}