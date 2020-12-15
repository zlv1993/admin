package com.zlv.admin.config.security;

import com.alibaba.fastjson.JSONObject;

import com.zlv.admin.domain.User;
import com.zlv.admin.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject object=new JSONObject();
        User user= (User)authentication.getPrincipal();
        String token= jwtTokenUtil.generateToken(user);
        object.put("code", "200");
        object.put("msg", "登陆成功");
        object.put("token",token);
        out.write(object.toJSONString());
        out.close();
    }
}
