package com.zlv.admin.service;


import com.zlv.admin.domain.User;
import com.zlv.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findById(int id){
        return userMapper.findById(id);
    }
    public List<User> findAll(){
        return userMapper.findAll();
    }

}
