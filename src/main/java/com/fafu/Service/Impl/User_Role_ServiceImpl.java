package com.fafu.Service.Impl;

import com.fafu.Service.User_Role_Service;
import com.fafu.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class User_Role_ServiceImpl implements User_Role_Service {
    @Autowired
    private RoleDao roleDao;
    @Override
    public boolean Insert_User_Rle(String identity, Integer uid) {
        Integer num,sum = 0;
        Integer rid =  find_role(identity);
        num = roleDao.save_user_role(rid,uid);
        if(num >= 0){
            return true;
        }
        return false;
    }

    @Override
    public void delete_User_Role(Integer uid) {
        roleDao.delete_user_role(uid);
    }

    @Override
    public Integer find_role(String identity) {

        Integer num = roleDao.findRid(identity);

        return num;
    }
}
