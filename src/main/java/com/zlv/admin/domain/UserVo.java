package com.zlv.admin.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class UserVo implements Serializable {
    private int id;
    private String username;
    private String email;
    private String phone;
    private String nickName;
    private String avator;
    private String address;
    private Date createTime;
    private Date updateTime;
    private String roleName;
}
