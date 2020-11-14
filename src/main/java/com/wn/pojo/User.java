package com.wn.pojo;

public class User {
    private Integer userid;
    private String username;
    private Integer age;
    private String password;

    @Override
    public String toString() {
        return "姓名:"+username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Integer userid, String username, Integer age, String password) {
        this.userid = userid;
        this.username = username;
        this.age = age;
        this.password = password;
    }
}
