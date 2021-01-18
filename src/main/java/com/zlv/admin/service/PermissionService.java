package com.zlv.admin.service;



import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;
import com.zlv.admin.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    public List<Permission> getAll(){
        return permissionMapper.getAll();
    }
    public List<PermissionVo> getPermission(String username){
        return permissionMapper.getPermission(username);
    }
    public int addPermission(Permission permission){return  permissionMapper.addPermission(permission);}
    public int deletePermission(int id){return  permissionMapper.deletePermission(id);}
}
