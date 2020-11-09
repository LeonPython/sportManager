package com.wyh.springbootmybatisdemo.controller;

import com.wyh.springbootmybatisdemo.mapper.UserMapper;
import com.wyh.springbootmybatisdemo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping
    public User findUser(@RequestParam(value = "id") Long id){
        return userMapper.findById(id);
    }
}
