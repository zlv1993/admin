package com.zlv.admin.mapper;



import com.zlv.admin.domain.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface  UserMapper {
     User findById(int id);
     User findByName(String username);
     List<User> list(String username, String role);
}
