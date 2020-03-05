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
    public boolean Insert_User_Rle(List<String> identitys, Integer uid) {
        Integer num,sum = 0;
        List<Integer> rids =  find_role(identitys);
        for(Integer rid : rids){
            num = roleDao.save_user_role(rid,uid);
            sum+=num;
        }
        if(sum >= rids.size()){
            return true;
        }
        return false;
    }

    @Override
    public void delete_User_Role(Integer uid) {
        roleDao.delete_user_role(uid);
    }

    @Override
    public List<Integer> find_role(List<String> identitys) {

        List<Integer> rids = new ArrayList<>();
        for(String identity : identitys){
            Integer num = roleDao.findRid(identity);
            rids.add(num);
        }
        return rids;
    }
}
