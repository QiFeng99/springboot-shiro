package com.example.springbootshiro.service;


import com.example.springbootshiro.po.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    List<User> findName(String name);
}
