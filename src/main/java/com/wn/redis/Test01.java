/*
package com.wn.redis;

import com.alibaba.fastjson.JSON;
import com.wn.pojo.User;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
@XSlf4j
public class Test01 {
    @Autowired
    private User user;
    @Autowired
    private RedisService redisService;


    @RequestMapping("/addUser")
    public User test1() {
        // 如果是个实体，我们可以使用json工具转成json字符串，
        user = new User("陈胜", 30, "123456", "1");

        */
/**
         * fastjson --JSON 用法
         * 对象转json字符串JSON.toJSONString(user)
         * 字符串转对象User user1 = JSON.parseObject(userInfo, User.class);
         * *//*


        //把对象类型转为json格式,并调用方法存到redis里
        redisService.setString("userInfo", JSON.toJSONString(user));
*/
/*
        log.info("用户信息：{}", redisService.getString("userInfo"));
*//*


        //根据key从redis里取出数据
        String userInfo = redisService.getString("userInfo");

        //反序列化
        User user1 = JSON.parseObject(userInfo, User.class);

        return user1;
    }
}
*/
