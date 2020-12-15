package com.zlv.admin.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable , GrantedAuthority {
    private int id;
    private  String role;
    private  String name;
    private String desc;
    private Date createTime;
    private Date updateTime;
    public Role() {
    }

    public Role(int id, String role, String name, String desc, Date createTime) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.desc = desc;
        this.createTime = createTime;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
