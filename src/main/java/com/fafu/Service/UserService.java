package com.fafu.Service;

import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.pages.PageList_result_list;
import com.fafu.domain.user.Role;
import com.fafu.domain.user.User;

import java.util.List;


public interface UserService {
    public User findUser(String username);
    public Some_Data_Resp findRole();
    public Some_Data_Resp findAll_User(String query,Integer page,Integer rows);
    public Some_Data_Resp findId_User(Integer uid);
    public Some_Data_Resp save_User(List<String> identitys,User user);
    public Some_Data_Resp update_User(List<String> identitys,User user);
    public Some_Data_Resp delete_User(Integer uid);
}
