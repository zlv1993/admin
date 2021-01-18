package com.zlv.admin.controller;


import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;
import com.zlv.admin.domain.User;
import com.zlv.admin.service.PermissionService;
import com.zlv.admin.service.UserService;
import com.zlv.admin.utils.JwtTokenUtil;
import com.zlv.admin.utils.R;
import com.zlv.admin.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
  private PermissionService permissionService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @RequestMapping("/findAll")
  private R findAll(){
       List<Permission> permission=  permissionService.getAll();
    return  R.ok(permission);
  }
    @PostMapping("/add")
   private   R addPermission(@RequestBody Permission permission){
           permission.setCreateTime(Calendar.getInstance().getTime());
        int num=permissionService.addPermission(permission);
        if(num>0){
          return  R.ok(num);
        }else{
          return   R.fail(201,"数据插入失败",new ArrayList<>());
        }
   }
    @DeleteMapping("/delete")
    private   R deletePermission(int id){
                int num=permissionService.deletePermission(id);
        if(num>0){
            return  R.ok(num);
        }else{
            return   R.fail(201,"删除失败",new ArrayList<>());
        }
    }
    @GetMapping("/get")
    private R getByToken(String token){
        String authToken=token.substring(this.tokenHead.length());
        String userName = jwtTokenUtil.getUserNameFromToken(authToken);
        List<PermissionVo> permissionVos=  permissionService.getPermission(userName);
        return  R.ok(permissionVos);

    }
}
