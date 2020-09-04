package com.winter.springdatademo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName : User
 * @Description : 用户表
 * @Author : Winter
 * @Date: 2020-09-04 08:51
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;

}
