package com.zlv.admin.mapper;


import com.zlv.admin.domain.User;
import com.zlv.admin.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRoleMapper {
     int insert(UserRole userRole);
}
