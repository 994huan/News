package com.fafu.config.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//@Component("myUserSuccessHandler")
//public class LoginUserSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    private ObjectMapper objectMapper= new ObjectMapper();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
////         允许跨域
//        response.setHeader("Access-Control-Allow-Origin", "*");
////         允许自定义请求头token(允许head跨域)
//        response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
//        Map<String,String> map = new HashMap<>();
//        map.put("status","ok");
//        map.put("msg","登录成功");
//        System.out.println("登录成功");
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(map));
//    }
//}
