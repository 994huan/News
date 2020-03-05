package com.fafu.controller;


import com.fafu.Service.UserService;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.pages.PageList_result_list;
import com.fafu.domain.user.User;
import com.fafu.domain.user.User_login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    //判断用户
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public void login(User user){
    }
    //退出
    @GetMapping("/logout")
    public void logout(){
        SecurityContextHolder.clearContext();
    }

    @RequestMapping(path = "/user/roles",method = RequestMethod.GET)
    public Some_Data_Resp findAll_role(){
        return userService.findRole();
    }

    @RequestMapping(path = "/user/list",method = RequestMethod.GET)
    public Some_Data_Resp findAll_User(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                             @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                             String query){
        return userService.findAll_User(query,page,row);
    }
    @RequestMapping(path = "user/{uid}",method = RequestMethod.GET)
    public Some_Data_Resp findId_User(@PathVariable("uid") Integer uid){
        return userService.findId_User(uid);
    }

    @RequestMapping(path = "/user/add",method = RequestMethod.POST)
    public Some_Data_Resp save_User(User_login user){
        return userService.save_User(user);
    }
    @RequestMapping(path = "/user/{uid}",method = RequestMethod.PUT)
    public Some_Data_Resp update_User(@PathVariable("uid") Integer uid, User_login user){
        user.setUid(uid);
        return userService.update_User(user);
    }
    @RequestMapping(path = "/user/{uid}",method = RequestMethod.DELETE)
    public Some_Data_Resp delete_User(@PathVariable("uid") Integer uid){
        return userService.delete_User(uid);
    }
}
