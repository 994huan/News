package com.fafu.Service.Impl;

import com.fafu.Service.UserService;
import com.fafu.Service.User_Role_Service;
import com.fafu.dao.RoleDao;
import com.fafu.dao.UserDao;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.pages.PageList_result_list;
import com.fafu.domain.user.*;
import com.fafu.until.Judge_Resp;
import com.fafu.until.String_List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private Role_res role_res;
    @Autowired
    private User_Role_Service user_role_service;

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }

    @Override
    public Some_Data_Resp findRole() {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        Map map = new HashMap();
        List<Role> roles =  roleDao.findAll_Role();
        role_res.setList(roles);
        some_data_resp.setData(role_res);
        Judge_Resp.getMap(map,roles,"获取","200");
        some_data_resp.setMeta(map);
        return some_data_resp;
    }

    @Override
    public Some_Data_Resp findAll_User(String query,Integer page,Integer rows) {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        PageList_result_list pageList_result_list = new PageList_result_list();
        Map map = new HashMap();

        query = Judge_Resp.getquery(query);
        PageHelper.startPage(page,rows);
        List<User_login> users = userDao.findAll_User(query);
        System.out.println(users);
        PageInfo<User_login> pageInfo = new PageInfo<>(users);
        pageList_result_list.setList(users);
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        Judge_Resp.getMap(map,users,"获取","200");
        some_data_resp.setData(pageList_result_list);
        some_data_resp.setMeta(map);
        return some_data_resp;
    }

    @Override
    public Some_Data_Resp findId_User(Integer uid) {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        Map map = new HashMap();

        User_login user = userDao.findId_User(uid);
        Judge_Resp.getMap(map,user,"获取","200");
        some_data_resp.setData(user);
        some_data_resp.setMeta(map);

        return some_data_resp;
    }

    @Override
    public Some_Data_Resp save_User(User_login user) {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        Map map = new HashMap();
        User_resp user_resp = new User_resp();


        Integer num = userDao.save_User(user);
        boolean judge =  user_role_service.Insert_User_Rle(user.getIdentity(),user.getUid());
        if(num <= 0 || judge == false ) num = null;
        Judge_Resp.getMap(map,num,"添加","200");
        user_resp.setUid(user.getUid());
        user_resp.setUsername(user.getUsername());
        some_data_resp.setData(user_resp);
        some_data_resp.setMeta(map);
        return some_data_resp;
    }

    @Override
    public Some_Data_Resp update_User(User_login user) {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        Map map = new HashMap();
        User_resp user_resp = new User_resp();

        Integer num = userDao.update_User(user);
        user_role_service.delete_User_Role(user.getUid());
        boolean judge = user_role_service.Insert_User_Rle(user.getIdentity(),user.getUid());

        if(num < 0 || judge == false) num = null;
        Judge_Resp.getMap(map,num,"修改","200");
        user_resp.setUid(user.getUid());
        user_resp.setUsername(user.getUsername());
        some_data_resp.setData(user_resp);
        some_data_resp.setMeta(map);
        return some_data_resp;
    }


    @Override
    public Some_Data_Resp delete_User(Integer uid) {
        Some_Data_Resp some_data_resp = new Some_Data_Resp();
        Map map = new HashMap();

        user_role_service.delete_User_Role(uid);
        Integer num = userDao.detele_User(uid);
        if(num <= 0) num = null;
        Judge_Resp.getMap(map,num,"删除","200");
        some_data_resp.setData(null);
        some_data_resp.setMeta(map);
        return some_data_resp;
    }
}
