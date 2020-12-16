package com.zlv.admin.controller;


import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.User;
import com.zlv.admin.service.PermissionService;
import com.zlv.admin.service.UserService;
import com.zlv.admin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
  private PermissionService permissionService;
    @RequestMapping("/findAll")
  private R findAll(){

       List<Permission> permission=  permissionService.getAll();
    return  R.ok(permission);
  }
    @RequestMapping("/getTree")
  private List<Permission> getTree(){
        List<Permission> permission=  permissionService.getTree();
        return permission;
    }
}
