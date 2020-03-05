package com.fafu.controller;

import com.fafu.Service.NewService;
import com.fafu.domain.Data_resp;
import com.fafu.domain.files.myFiles;
import com.fafu.domain.news.News;
import com.fafu.domain.pages.PageList_News_Category;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.until.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NewContoller {
    @Autowired
    private NewService newService;

    private Data_resp data_resp;
    private Map<String,String> meta = new HashMap<>();
    //查询所有
    @RequestMapping(path = "/news",method = RequestMethod.GET)
    public Some_Data_Resp findAll(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                  @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                   String query){

        Some_Data_Resp someDataResp =  newService.findAll(page,row,query);
        return someDataResp;
    }
    //根据id查询
    @RequestMapping(path = "/news/{newsId}",method = RequestMethod.GET)
    public Some_Data_Resp findNewsId(@PathVariable(name = "newsId") Integer newsId){
        return newService.findNewId(newsId);
    }
    //查询所有种类

    @RequestMapping(path = "/news/all_category",method = RequestMethod.GET)
    public Some_Data_Resp findAll_category(){

        return newService.findAll_Catetory();
    }
    //根据种类id查询

    @RequestMapping(path = "/news/category/{categoryId}", method = RequestMethod.GET)
    public Some_Data_Resp<PageList_News_Category> findAll_News_category(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer page,
                                                                    @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer row,
                                                                    String query, @PathVariable("categoryId") Integer categoryId){
        Some_Data_Resp<PageList_News_Category> someDataResp = newService.findAll_News_category(page, row, query,categoryId);
        return someDataResp;
    }
    //增加新闻
    @RequestMapping(path = "/news",method = RequestMethod.POST)
    public Data_resp  save(@RequestParam(name = "categoryName",required = false) List<String> categoryName,News news){
        data_resp = newService.insert(news,categoryName);
        return data_resp;
    }
    //删除新闻
    @RequestMapping(path = "/news/{newsId}",method = RequestMethod.DELETE)
    public Data_resp  delete( @PathVariable Integer newsId){
        data_resp = newService.delete(newsId);
        return data_resp;
    }
    //更新新闻
    @RequestMapping(path = "/news/{newsId}",method = RequestMethod.PUT)
    public Data_resp update(@RequestParam(name = "categoryName",required = false) List<String> categoryName,News news, @PathVariable("newsId") Integer newsId) throws ParseException {
        news.setNewsId(newsId);
        System.out.println(news);
        data_resp = newService.update(news, categoryName);
        return data_resp;
    }
    //上传新闻图
    @RequestMapping(path = "/news/upload/{newsId}",method = RequestMethod.POST)
    public Data_resp imgUpload(@RequestParam("img") MultipartFile file, String path, @PathVariable("newsId") Integer newsId) throws FileNotFoundException {
        myFiles files = FileUntil.simpleUpload(file, path);
        return newService.imgUpload(files,newsId);
    }
    //下载新闻图
    @RequestMapping(path = "/news/download/{newsId}",method = RequestMethod.GET)
    public Data_resp imgshow(@PathVariable("newsId") Integer newsId, HttpServletRequest request){
        String real = request.getContextPath();
        return newService.imgshow(newsId,real);
    }
}
