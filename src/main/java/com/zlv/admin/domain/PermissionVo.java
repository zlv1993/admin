package com.zlv.admin.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class PermissionVo {
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
    private List<PermissionVo> children=new ArrayList<>();
}
