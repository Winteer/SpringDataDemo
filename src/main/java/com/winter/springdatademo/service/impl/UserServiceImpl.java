package com.winter.springdatademo.service.impl;

import com.winter.springdatademo.model.UserInfo;
import com.winter.springdatademo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : UserServiceImpl
 * @Description : 用户业务层实现
 * @Author : Winter
 * @Date: 2020-09-04 16:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo save(UserInfo user) {
        return null;
    }

    @Override
    public UserInfo update(UserInfo user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserInfo find(Long id) {
        return null;
    }

    @Override
    public List<UserInfo> findByName(String name) {
        return null;
    }
}
