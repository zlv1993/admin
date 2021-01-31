package com.zlv.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlv.admin.domain.User;
import com.zlv.admin.domain.UserRole;
import com.zlv.admin.service.UserRoleService;
import com.zlv.admin.service.UserService;
import com.zlv.admin.utils.JwtTokenUtil;
import com.zlv.admin.utils.PageUtil;
import com.zlv.admin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
  private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @RequestMapping("/findById/{id}")
  private User findById(@PathVariable Integer id){
      User user=  userService.findById(id);
       user.setPassword("");
      return user;
  }
    @RequestMapping("/findByToken")
    private R findByToken(String token){
        String authToken=token.substring(this.tokenHead.length());
      String userName = jwtTokenUtil.getUserNameFromToken(authToken);
      User user=  userService.findByName(userName);
      return R.ok(user);
    }

    @RequestMapping("/list")
  public PageUtil list(int pageNum, int pageSize,String username, Integer roleId){
      PageHelper.startPage(pageNum, pageSize);
      List<User> allUser= userService.list(username,roleId);
      PageInfo<User> pageInfo =new PageInfo<>(allUser);
      PageUtil<User> pageUtil=new PageUtil<>(pageInfo);
      return pageUtil;
  }
  @PostMapping("/insert")
  public R insert(@RequestBody User user, UserRole userRole){
      String password = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(password);
      userService.insert(user);

      int userId= user.getId();
      userRole.setUserId(userId);
      int num=  userRoleService.insert(userRole);
       if(num==1){
         return   R.ok();
     }else{
         return R.fail(500,"插入失败",0);
     }
  }
  @DeleteMapping("/del")
  public R del(int id){
        int num=userService.del(id);
      if(num==1){
          return   R.ok();
      }else{
          return R.fail(500,"删除失败",0);
      }
  }

}
