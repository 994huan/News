package com.fafu.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_String {
    public static String date_string(Date data , String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        String datastring = simpleDateFormat.format(data);
        return datastring;
    }
    public static Date string_date(String str,String datastring) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        Date date = simpleDateFormat.parse(datastring);
        return date;
    }
}
