package com.zlv.admin.controller;


import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;
import com.zlv.admin.domain.User;
import com.zlv.admin.service.PermissionService;
import com.zlv.admin.service.UserService;
import com.zlv.admin.utils.R;
import com.zlv.admin.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/findAll")
  private R findAll(){

       List<Permission> permission=  permissionService.getAll();
    return  R.ok(permission);
  }
    @RequestMapping("/getTree")
  private List<PermissionVo> getTree() throws NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        List<PermissionVo> permission=  permissionService.getTree();
        TreeUtil<PermissionVo> treeUtil=new TreeUtil<>();
        return treeUtil.getTree(permission,"id","pid");
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
}
