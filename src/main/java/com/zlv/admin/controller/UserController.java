package com.zlv.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlv.admin.domain.User;
import com.zlv.admin.service.UserService;
import com.zlv.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
  private UserService userService;
    @RequestMapping("/findById/{id}")
  private User findById(@PathVariable Integer id){
      User user=  userService.findById(id);
    return user;
  }
    @RequestMapping("/findAll")
  public PageUtil findAll(){
      PageHelper.startPage(2,2);

      List<User> allUser= userService.findAll();
      PageInfo<User> pageInfo =new PageInfo<>(allUser);
      PageUtil<User> pageUtil=new PageUtil<>(pageInfo);
      return pageUtil;
  }
}
