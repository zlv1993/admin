package com.zlv.admin.service;



import com.zlv.admin.domain.UserRole;
import com.zlv.admin.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    public  int insert(UserRole userRole){ return userRoleMapper.insert(userRole);}

}
