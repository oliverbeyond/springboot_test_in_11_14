package com.wn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieUtil {
/*    @Autowired
    JedisUtil jedisUtil;*/

    //保存到cookie
    public static void saveCookie(String redisKey, HttpServletResponse response) {
        Cookie cookie = new Cookie("userCookie", redisKey);
        cookie.setMaxAge(60 * 60 * 24 * 14);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    //查询cookie
    public static String queryCookie(HttpServletRequest request) {
        Cookie[] cks = request.getCookies();//获取浏览器中的cookie
        for (Cookie ck : cks) {//是把浏览器的所有的cookie取出来,挨个匹配,怎么匹配呢?查cookie的key值,若key值全部符合,则说明有想找的cookie
            if (ck.getName().equals("userCookie")) {//判断cookie中是否存有key为userCookie的值
                String redisKey = ck.getValue();//登陆Servlet中存储的cookie模式: username:password
                String value = JedisUtil.get(redisKey);
                if (value != null) {
                    System.out.println("找到了您要的cookie,而且redis里有数据!");
                    return value;
                }
                else {
                    System.out.println("找到了您要的cookie,但是redis里面的数据过期了...");
                    return null;
                }
            }
        }
        System.out.println("没找到您要的cookie...");
        return null;
    }

    //清除cookie,本质是把cookie改了
    public static String deleteCookie(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cks = request.getCookies();//获取浏览器中的cookie
        System.out.println(cks);
        for (Cookie ck : cks) {//是把浏览器的所有的cookie取出来,挨个匹配,怎么匹配呢?查cookie的key值,若key值全部符合,则说明有想找的cookie
            if (ck.getName().equals("userCookie")) {//判断cookie中是否存有key为userCookie的值
                Cookie cookie = new Cookie(ck.getName(),null);
                cookie.setMaxAge(60 * 60 * 24 * 14);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return null;
    }
}
