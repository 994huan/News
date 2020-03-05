package com.fafu.Service;

import java.util.List;

public interface User_Role_Service {
    public boolean Insert_User_Rle(String identity,Integer uid);
    public void delete_User_Role(Integer uid);
    public Integer find_role(String identity);
}
