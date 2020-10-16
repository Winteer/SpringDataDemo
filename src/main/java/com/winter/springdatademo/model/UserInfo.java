package com.winter.springdatademo.model;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName : UserInfo
 * @Description : 用户信息
 * @Author : Winter
 * @Date: 2020-09-04 08:51
 */
public class UserInfo {
    private Long id;
    private String name;
    @NotBlank(message = "用户名不能为空！")
    private String username;
    @NotBlank(message = "密码不能为空！")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
