package com.zlv.admin.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil {
    private int code =200;
    private String msg ="查询成功";
    private List<?> data;
    private long count;
    private long pages;
    public PageUtil(List<?> data){
        PageInfo<?> pageInfo =new PageInfo<>(data);
        this.count=pageInfo.getTotal();
        this.data=pageInfo.getList();
        this.pages=pageInfo.getPages();
    }

}
