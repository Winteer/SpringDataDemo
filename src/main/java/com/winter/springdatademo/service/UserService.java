package com.winter.springdatademo.service;

import com.winter.springdatademo.model.UserInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface UserService {

    UserInfo save(@RequestBody UserInfo user);

    UserInfo update(@RequestBody UserInfo user);

    void delete(@PathVariable Long id);

    UserInfo find(@PathVariable Long id);

    List<UserInfo> findByName(@PathVariable String name);

}
