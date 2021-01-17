package com.zlv.admin.config.security;

import com.alibaba.fastjson.JSONObject;

import com.zlv.admin.domain.PermissionVo;
import com.zlv.admin.domain.User;
import com.zlv.admin.service.PermissionService;
import com.zlv.admin.utils.JwtTokenUtil;
import com.zlv.admin.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Component
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    PermissionService permissionService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject object=new JSONObject();
        HashMap<String,Object> data=new HashMap<>();
        User user= (User)authentication.getPrincipal();

        try {
            List<PermissionVo> permission=  permissionService.getTree(user.getId());
            TreeUtil<PermissionVo> treeUtil=new TreeUtil<>();
            List<PermissionVo> trees=treeUtil.getTree(permission,"id","pid");
            String token= jwtTokenUtil.generateToken(user);
            object.put("code", 200);
            object.put("msg", "登陆成功");
            data.put("token",token);
            data.put("permission",trees);
            object.put("data",data);
            out.write(object.toJSONString());
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
