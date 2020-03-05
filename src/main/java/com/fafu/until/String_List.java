package com.fafu.until;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_List {
    public static List<String> getList(String str){
        List<String> list = new ArrayList<>();
        if(str != null)
            list = Arrays.asList(str.split(","));
        return list;
    }

    public static String getString(List<String> list){
        StringBuffer stringBuffer = new StringBuffer();
        if(list != null){
            for(String str : list){
                stringBuffer.append(str+",");
            }
        }
        return stringBuffer.toString();
    }
}
