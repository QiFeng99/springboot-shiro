package com.example.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootshiro.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Resource
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList();

    List<User> findName(@Param("name") String name);
}
