package com.wn.mapper;

import com.wn.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where username=#{username} and password = #{password}")
    User login(String username, String password);

    @Select("select * from user where username=#{username}")
    User register(String username);

    @Update("update user set username = 'zhangsan' where userid = #{userid}")
    int updateUser(Integer userid);

    /*admin查看所有用户*/
    @Select("select * from user")
    List<User> selectUser();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int insert(String username,String password);

}
