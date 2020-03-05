package com.fafu.Service;


import com.fafu.domain.Data_resp;
import com.fafu.domain.files.myFiles;
import com.fafu.domain.news.News;
import com.fafu.domain.pages.PageList_News_Category;
import com.fafu.domain.Some_Data_Resp;
import java.text.ParseException;
import java.util.List;


public interface NewService {
    public Some_Data_Resp findAll(Integer page, Integer row,String query);

    public Some_Data_Resp findNewId(Integer newsId);

    public Some_Data_Resp findAll_Catetory();

    public Some_Data_Resp<PageList_News_Category> findAll_News_category(Integer page, Integer row, String query, Integer categoryId);

    public Data_resp insert(News news, List<String> categoryName);

    public Data_resp update(News news,List<String> categoryName) throws ParseException;

    public Data_resp delete(Integer id);

    public Data_resp imgUpload(myFiles file,Integer newsId);

    public Data_resp imgshow(Integer newsId,String real);
}
