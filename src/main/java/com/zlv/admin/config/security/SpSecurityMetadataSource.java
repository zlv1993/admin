package com.zlv.admin.config.security;



import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.Role;
import com.zlv.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class SpSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    PermissionService permissionService;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi=(FilterInvocation) object;
        String url=fi.getRequestUrl();
        List<Permission> permissions=permissionService.getAll();
        for (Permission permission :permissions){
            if(antPathMatcher.match(permission.getUrl(),url)){
                List<Role> roles=permission.getRoles();
                String[] roleList=new String[roles.size()];
                for (int i=0;i<roles.size();i++){
                    roleList[i]=roles.get(i).getRole();
                }
                return SecurityConfig.createList(roleList);
            }

        }

        return SecurityConfig.createList("ROLE_UNPERMISSION");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
