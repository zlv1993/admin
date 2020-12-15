package com.zlv.admin.config.security;



import com.zlv.admin.domain.Role;
import com.zlv.admin.domain.User;
import com.zlv.admin.mapper.RoleMapper;
import com.zlv.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailService")
public class SpUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.findByName(username);
        if(user!=null){
            int userId=user.getId();
            List<Role> roles=roleMapper.findById(userId);
            user.setAuthorities(roles);
        }else{
            throw  new UsernameNotFoundException("用户名或密码不正确");
        }

        return user;
    }
}
