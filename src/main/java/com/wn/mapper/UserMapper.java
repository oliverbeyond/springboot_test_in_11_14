package com.wn.mapper;

import com.wn.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where username=#{username} and password = #{password}")
    User login(String username,String password);
    @Update("update user set username = 'zhangsan' where userid = #{userid}")
    int updateUser(Integer userid);

}
