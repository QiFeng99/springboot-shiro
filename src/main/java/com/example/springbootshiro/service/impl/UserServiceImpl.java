package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.dao.UserMapper;
import com.example.springbootshiro.po.User;
import com.example.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<User> findName(String name) {
        return userMapper.findName(name);
    }
}
