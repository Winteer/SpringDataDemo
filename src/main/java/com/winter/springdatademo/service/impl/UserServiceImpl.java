package com.winter.springdatademo.service.impl;

import com.winter.springdatademo.model.User;
import com.winter.springdatademo.model.UserInfo;
import com.winter.springdatademo.repository.UserRepository;
import com.winter.springdatademo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public UserInfo save(UserInfo userInfo) {
        User user = new User();
        BeanUtils.copyProperties(userInfo, user);
        userRepository.save(user);
        return userInfo;
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        User user = new User();
        BeanUtils.copyProperties(userInfo, user);
        return null;
    }

    @Override
    public void delete(Long id) {


    }

    @Override
    public UserInfo find(Long id) {
        return userRepository.findById(id).get().buildInfo();
    }

    @Override
    public List<UserInfo> findByName(String name) {
        return null;
    }
}
