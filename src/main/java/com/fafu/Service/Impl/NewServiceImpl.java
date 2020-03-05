package com.fafu.Service.Impl;

import com.fafu.Service.NewService;
import com.fafu.Service.News_Category_Service;
import com.fafu.dao.NewDao;
import com.fafu.domain.Data_resp;
import com.fafu.domain.files.myFiles;
import com.fafu.domain.news.*;
import com.fafu.domain.pages.PageList_News;
import com.fafu.domain.pages.PageList_News_Category;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.until.Date_String;
import com.fafu.until.FileUntil;
import com.fafu.until.Judge_Resp;
import com.fafu.until.Packaged;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NewServiceImpl implements NewService {
    @Autowired
    private NewDao newDao;
    @Autowired
    private Data_resp data;

    @Autowired
    private PageList_News pageListNews;
    @Autowired
    private PageList_News_Category pageList_news_category;
    @Autowired
    private Category_Resp category_resp;
    @Autowired
    private News_Category_Service newsCategoryService;
    @Value("${web.DownloadUrl}")
    private String Url;

    private Integer num;

    private Map<String,String> map = new HashMap<>();

    private Map<String,String> datmap = new HashMap<>();



    @Override
    public  Some_Data_Resp findAll(Integer page, Integer row,String query) {
        query = Judge_Resp.getquery(query);
        PageHelper.startPage(page,row);
        List<News> news =  newDao.findAll(page, row,query);
        Judge_Resp.getMap(map,news,"获取","200");
        PageInfo<News> pageInfo = new PageInfo<>(news);
        pageListNews.setTotalPage(pageInfo.getTotal());
        pageListNews.setPageNum(pageInfo.getPageNum());
        List<News_Resp> news_resps = Packaged.setNews_Resp(news);
        pageListNews.setNews(news_resps);
        Some_Data_Resp someDataResp = new Some_Data_Resp();
        someDataResp.setData(pageListNews);
        someDataResp.setMeta(map);
        return someDataResp;
    }

    @Override
    public Some_Data_Resp findNewId(Integer newsId) {
        News news = newDao.findNewsId(newsId);
        Judge_Resp.getMap(map,news,"查询","200");
        News_Resp news_resp = Packaged.setNew_Resp(news);
        Some_Data_Resp someDataResp = new Some_Data_Resp();
        someDataResp.setData(news_resp);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    @Override
    public synchronized Some_Data_Resp findAll_Catetory() {
        List<Category> categories = newDao.findAll_category();
        Judge_Resp.getMap(map,categories,"获取","200");
        category_resp.setCount(categories.size());
        category_resp.setCategories(categories);
        Some_Data_Resp someDataResp = new Some_Data_Resp();
        someDataResp.setData(categories);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    @Override
    public synchronized  Some_Data_Resp<PageList_News_Category> findAll_News_category(Integer page, Integer row, String query, Integer categoryId) {
        query = Judge_Resp.getquery(query);
        String categoryName = newsCategoryService.findCategoryName(categoryId);
        PageHelper.startPage(page,row);
        List<News> news = newDao.findAll_News_category(query,categoryId);
        Judge_Resp.getMap(map,news,"获取","200");
        PageInfo<News> pageInfo = new PageInfo<>(news);
        pageList_news_category.setTotalPage(pageInfo.getTotal());
        pageList_news_category.setCategoryId(categoryId);
        pageList_news_category.setNews(news);
        pageList_news_category.setPageNum(pageInfo.getPageNum());
        pageList_news_category.setCategoryName(categoryName);
        Some_Data_Resp someDataResp = new Some_Data_Resp();
        someDataResp.setMeta(map);
        someDataResp.setData(pageList_news_category);
        return someDataResp;
    }


    @Override
    public Data_resp insert(News news,List<String> categoryNames) {
        List<Integer> categoryIds = newsCategoryService.findCategoryId(categoryNames);
        num = newDao.insert(news);
        if(num <= 0) num = null;
        newsCategoryService.insert(news.getNewsId(),categoryIds);
        Judge_Resp.getMap(map,num,"添加","201");
        data.setMeta(map);
        data.setData(Packaged.setNews(news,"releaseTime",news.getReleaseTime()));
        return data;
    }

    @Override
    public Data_resp update(News news,List<String> categoryNames) throws ParseException {
        String date = Date_String.date_string(new Date(),"yyyy-hh-dd hh:mm:ss");
        news.setUpdateTime(date);
        newsCategoryService.delete(news.getNewsId());
        List<Integer> categoryIds = newsCategoryService.findCategoryId(categoryNames);
        newsCategoryService.insert(news.getNewsId(),categoryIds);
        if(!news.getCategoryName().contains("聚焦要点")){
            News beforeNews = newDao.findNewsId(news.getNewsId());
            if(beforeNews.getImgpath().contains("/")){
                FileUntil.deleteFile(beforeNews.getImgpath());
                news.setImgpath(null);
            }
        }
        num = newDao.update(news);
        if(num <= 0) num = null;
        Judge_Resp.getMap(map,num,"修改","200");
        data.setMeta(map);
        data.setData(Packaged.setNews(news,"UpdateTime",news.getUpdateTime()));
        return data;
    }

    @Override
    public Data_resp delete(Integer id) {
        News news = newDao.findNewsId(id);
        newsCategoryService.delete(id);
        num = newDao.delete(id);
        boolean judge = FileUntil.deleteFile(news.getImgpath());
        if(num <= 0 || judge == false) num = null;
        Judge_Resp.getMap(map,num,"删除","200");
        data = Packaged.setData_resp(null,map);
        return data;
    }

    @Override
    public Data_resp imgUpload(myFiles files, Integer newsId) {
        News news = newDao.findNewsId(newsId);
        if(news.getImgpath() != null){
            FileUntil.deleteFile(news.getImgpath());
        }
        num = newDao.updateImg(newsId,files.getFilePath());
        if(num <= 0) num = null;
        Judge_Resp.getMap(map,num,"上传","200");
        data = Packaged.setData_resp(null,map);
        return data;
    }

    public Data_resp imgshow(Integer newsId,String real){
        News news = newDao.findNewsId(newsId);
        System.out.println(news.getImgpath());
        if(news.getImgpath()==null){
            map.put("msg","无img");
            datmap.put("url",null);
            data = Packaged.setData_resp(datmap,map);
        }else{
            String url = Url + real+"/download"+news.getImgpath();
            map.put("msg","获取成功");
            datmap.put("url",url);
            data = Packaged.setData_resp(datmap,map);
        }
        return data;
    }

}
