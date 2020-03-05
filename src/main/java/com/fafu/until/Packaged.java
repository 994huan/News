package com.fafu.until;

import com.fafu.domain.Data_resp;
import com.fafu.domain.files.myFiles;
import com.fafu.domain.news.News;
import com.fafu.domain.news.News_Resp;

import java.util.*;

public class Packaged {

    public static Map<String,String> setNews(News news, String date, Date datetime){
        Map map = new HashMap();
        String data_string;
        if(date == "releaseTime"){
            data_string= Date_String.date_string(datetime,"yyyy-hh-dd");
        }else {
            data_string= Date_String.date_string(datetime,"yyyy-hh-dd hh:mm:ss");
        }
       map.put("newsId",news.getNewsId().toString());
       map.put("title",news.getTitle());
       map.put("author",news.getAuthor());
       map.put(date,data_string);
       return map;
    }

    public static Map<String,String> setMyFiles(myFiles files){
        Map map = new HashMap();

        String data_string= Date_String.date_string(files.getUploadTime(),"YYYY-MM-dd hh:mm:ss");
        map.put("fid",files.getFid().toString());
        map.put("fileName",files.getFileName());
        map.put("uploadTime",data_string);
        map.put("username",files.getUsername());
        return map;
    }
    public static List<News_Resp> setNews_Resp(List<News> news){
        List<News_Resp> news_resps = new ArrayList<>();

        for(News newst :news){
            News_Resp news_resp = setNew_Resp(newst);
            news_resp.setAuthor(newst.getAuthor());
            news_resp.setContent(newst.getContent());
            news_resp.setEditor(newst.getEditor());
            news_resp.setImgpath(newst.getImgpath());
            news_resp.setNewsId(newst.getNewsId());
            news_resp.setTitle(newst.getTitle());
            news_resp.setSource(newst.getSource());
            news_resp.setReleaseTime(newst.getReleaseTime());
            news_resp.setUpdateTime(newst.getUpdateTime());
            news_resp.setCategoryName(String_List.getList(newst.getCategoryName()));
            news_resps.add(news_resp);
        }
        return news_resps;
    }

    public static News_Resp setNew_Resp(News news){
        News_Resp news_resp = new News_Resp();
        news_resp.setAuthor(news.getAuthor());
        news_resp.setContent(news.getContent());
        news_resp.setEditor(news.getEditor());
        news_resp.setImgpath(news.getImgpath());
        news_resp.setNewsId(news.getNewsId());
        news_resp.setTitle(news.getTitle());
        news_resp.setSource(news.getSource());
        news_resp.setReleaseTime(news.getReleaseTime());
        news_resp.setUpdateTime(news.getUpdateTime());
        news_resp.setCategoryName(String_List.getList(news.getCategoryName()));
        return news_resp;
    }

    public  static Data_resp setData_resp(Map<String,String> data,Map<String,String> map){
        Data_resp data_resp = new Data_resp();
        data_resp.setMeta(map);
        data_resp.setData(data);
        return data_resp;
    }

}
