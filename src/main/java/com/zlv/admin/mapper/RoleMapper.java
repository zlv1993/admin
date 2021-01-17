package com.zlv.admin.mapper;


import com.zlv.admin.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  RoleMapper {
    List<Role> findById(int id);
    List<Role> getAll();
}
