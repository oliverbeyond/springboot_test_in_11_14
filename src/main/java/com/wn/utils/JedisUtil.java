package com.wn.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;

@Component
public class JedisUtil {
/*    @Autowired
    CookieUtil cookieUtil;*/
    //连接redis
    //放值并设置有效时间
    public static void set(String username, HttpServletResponse response) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.setex("userRedis", 2000, username);
        CookieUtil.saveCookie("userRedis",response);
        jedis.close();
    }

    //登录时查询cookie,连接redis
    public static String get(String key) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String value = jedis.get(key);
        jedis.close();
        return value;
    }
}
