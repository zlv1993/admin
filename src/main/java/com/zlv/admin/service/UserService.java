package com.zlv.admin.service;


import com.zlv.admin.domain.User;
import com.zlv.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findById(int id){
        return userMapper.findById(id);
    }
    public User findByName(String name){
        return userMapper.findByName(name);
    }
    public List<User> list(String username, Integer roleId){
        return userMapper.list(username,roleId);
    }
    public  int insert(User user){ return userMapper.insert(user);}
    public int del(int id){return  userMapper.del(id);}
}
