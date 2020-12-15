package com.zlv.admin.domain;

import java.util.Date;
import java.util.List;

public class Permission {
    private int id;
    private int pid;
    private String url;
    private String path;
    private String component;
    private String name;
    private String icon;
    private int type;
    private Date createTime;
    private Date updateTime;
    private List<Role> roles;

    public Permission() {
    }

    public Permission(int id, int pid, String url, String path, String component, String name, String icon, int type, Date createTime, Date updateTime, List<Role> roles) {
        this.id = id;
        this.pid = pid;
        this.url = url;
        this.path = path;
        this.component = component;
        this.name = name;
        this.icon = icon;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
