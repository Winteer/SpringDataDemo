package com.winter.springdatademo.controller;

import com.winter.springdatademo.model.User;
import com.winter.springdatademo.model.UserInfo;
import com.winter.springdatademo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : UserController
 * @Description : 用户controller层
 * @Author : Winter
 * @Date: 2020-09-04 08:53
 */
@Api(value = "用户操作Api", tags = {"用户操作管理"})
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public UserInfo create(@RequestBody @Validated UserInfo user) {
        userService.save(user);
        return user;
    }

    @ApiOperation(value = "接口功能", notes = "作者")
    @PutMapping("/update")
    public UserInfo update(@RequestBody UserInfo user) {
        return userService.update(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
        System.out.println("接收到的id为：" + id);
    }

    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/find/{id}")
    public UserInfo find(@PathVariable Long id, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        if (user == null || !user.getId().equals(id)) {
            throw new RuntimeException("身份认证信息异常，获取用户信息失败！");
        }
        System.out.println("接收到的id为：" + id);
        return userService.find(id);
    }

    @ApiOperation(value = "根据姓名查询用户列表")
    @GetMapping("/query/{name}")
    public List<UserInfo> query(@PathVariable String name) {
        System.out.println("name：" + name);
        return userService.findByName(name);
    }


}