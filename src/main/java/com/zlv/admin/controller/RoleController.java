package com.zlv.admin.controller;

import com.zlv.admin.domain.Role;
import com.zlv.admin.service.RoleService;
import com.zlv.admin.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/getAll")
    public R getAll(){
        List<Role> roles=roleService.getAll();
        return R.ok(roles);
    }
}
