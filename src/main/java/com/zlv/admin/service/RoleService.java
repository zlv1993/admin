package com.zlv.admin.service;

import com.zlv.admin.domain.Role;
import com.zlv.admin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<Role> getAll(){
        return roleMapper.getAll();
    }

}
