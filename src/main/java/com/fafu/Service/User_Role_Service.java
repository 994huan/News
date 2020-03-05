package com.fafu.Service;

import java.util.List;

public interface User_Role_Service {
    public boolean Insert_User_Rle(List<String> identitys,Integer uid);
    public void delete_User_Role(Integer uid);
    public List<Integer> find_role(List<String>identitys);
}
