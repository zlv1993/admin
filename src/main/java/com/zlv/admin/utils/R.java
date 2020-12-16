package com.zlv.admin.utils;

import java.util.HashMap;

public class R  extends HashMap<String, Object> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private Object data;
    public  R() {
       put("code",200);
       put("msg","操作成功");
    }
    public  R(Object data){
        put("code",200);
        put("msg","操作成功");
        put("data",data);

    }
    public static R fail(int code,String msg,Object data) {
       R r= new R();
       r.setCode(code);
       r.setMsg(msg);
       r.setData(data);
       return  r;
    }
    public static R ok(Object data) {
        return new R(data);
    }

    public static R ok() {
        return new R(null);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

