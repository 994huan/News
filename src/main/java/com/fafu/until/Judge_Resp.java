package com.fafu.until;

import java.util.HashMap;
import java.util.Map;

public class Judge_Resp {

    public static <T>void getMap(Map<String,String> map,T file,String msg,String status) {
        if(file != null){
            map.put("msg",msg+"成功");
            map.put("status",status);
        }else {
            map.put("msg",msg+"失败");
            map.put("status","500");
        }
    }
    public static String getquery(String query){
        if(query == null){
            query = "%";
        }else {
            query = "%"+query+"%";
        }
        return query;
    }
}
