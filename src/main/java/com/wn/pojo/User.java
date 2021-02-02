package com.wn.pojo;

public class User {
    private Integer userid;
    private String username;
    private Integer age;
    private String password;
    private String roleid;
    private byte pic;

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

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public User() {
    }

    public User(String bookname, String writer, String path, String num) {
    }

    public User(Integer userid, String username, String password, String roleid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.roleid = roleid;
    }


    public User(Integer userid, String username, Integer age, String password, String roleid) {
        this.userid = userid;
        this.username = username;
        this.age = age;
        this.password = password;
        this.roleid = roleid;
    }

    public User(String username, Integer age, String password, String roleid) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.roleid = roleid;
    }

    /*   public User(String username, Integer age, String password, String roleid, String pic) {
            this.username = username;
            this.age = age;
            this.password = password;
            this.roleid = roleid;
            this.pic = pic;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    */
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }
}
