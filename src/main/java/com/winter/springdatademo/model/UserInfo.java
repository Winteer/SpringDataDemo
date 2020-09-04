package com.winter.springdatademo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName : UserInfo
 * @Description : 用户信息
 * @Author : Winter
 * @Date: 2020-09-04 08:51
 */
@Data
public class UserInfo {
    private Long id;
    private String name;
    private String username;
    private String password;
}
