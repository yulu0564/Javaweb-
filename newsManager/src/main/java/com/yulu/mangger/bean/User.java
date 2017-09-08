package com.yulu.mangger.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;            // id
    private String username;    // 用户名
    private String loginname;    // 登录名
    private String password;    // 密码
    private Integer status;        // 状态
    private Date createDate;    // 建档日期
    private String nickname;    // 昵称
    private String head_image;    // 头像
    // 无参数构造器
    public User() {
        super();
    }

    // setter和getter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", loginname="
                + loginname + ", password=" + password + ", status=" + status
                + ", createDate=" + createDate + "]";
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }
}
