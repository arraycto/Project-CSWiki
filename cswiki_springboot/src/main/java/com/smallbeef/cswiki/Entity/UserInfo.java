package com.smallbeef.cswiki.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * 用户类
 */
@Entity // 表示这是一个实体类
@Table(name = "userinfo") // 表示对应的表名是 userinfo
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserInfo {

    // 注意前端传值的字段要和此处一致

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长
    private int id;
    private String username;
    private String password;
    private String email;

    public UserInfo() {
    }

    public UserInfo(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
