/*
package com.wn.redis;

import com.alibaba.fastjson.JSON;
import com.wn.pojo.User;
import com.wn.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

//redis模板
public class RedisService {
    @Autowired
    private UserService userService;
    @Autowired
    private com.wn.redis.service.RedisService redisService;

    @RequestMapping("/addUser")
    public User test1(){
        // 如果是个实体，我们可以使用json工具转成json字符串，
        User user = new User("陈胜",30,"123456","1");

        */
/**
         * fastjson --JSON 用法
         *
         * 对象  转json字符串      JSON.toJSONString(user)
         * 字符串转对象     User user1 = JSON.parseObject(userInfo, User.class);
         * *//*


        redisService.setString("userInfo", JSON.toJSONString(user));
        log.info("用户信息：{}", redisService.getString("userInfo"));

        String userInfo = redisService.getString("userInfo");

        User user1 = JSON.parseObject(userInfo, User.class);

        return user1;
    }

    @RequestMapping("/addUserHash")
    public User testHash(){

        */
/**
         * fastjson --JSON 用法
         *
         * 对象  转json字符串      JSON.toJSONString(user)
         * 字符串转对象     User user1 = JSON.parseObject(userInfo, User.class);
         * *//*


        redisService.setHash("user", "name", "zs");
        log.info("用户姓名：{}", redisService.getHash("user","name"));

        String userInfo = redisService.getString("userInfo");

        User user1 = JSON.parseObject(userInfo, User.class);

        return user1;
    }

    @RequestMapping("/testList")
    public List<String> testList(){

        redisService.setList("list", "football");
        redisService.setList("list", "basketball");
        List<String> valList = redisService.getList("list",0,-1);
        for(String value :valList){
            log.info("list中有：{}", value);
        }
        return valList;
    }
}
*/
