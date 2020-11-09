package com.wyh.springbootmybatisdemo.mapper;
import com.wyh.springbootmybatisdemo.pojo.User;

import java.util.List;

public interface UserMapper {
    User findById(Long id);
    List<User> findAll();
}