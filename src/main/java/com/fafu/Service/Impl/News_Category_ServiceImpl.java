package com.fafu.Service.Impl;

import com.fafu.Service.News_Category_Service;
import com.fafu.dao.NewsId_categoryIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class News_Category_ServiceImpl implements News_Category_Service {
    @Autowired
    private NewsId_categoryIdDao newsIdCategoryIdDao;

    @Override
    public String findCategoryName(Integer categoryId) {
        return newsIdCategoryIdDao.find_categoryName(categoryId);
    }

    @Override
    public List<Integer> findCategoryId(List<String> categoryNames) {
        List<Integer> categoryIds = new ArrayList<>();
        if(categoryNames != null){
            for(String categoryName : categoryNames){
                Integer num = newsIdCategoryIdDao.find_categoryId(categoryName);
                categoryIds.add(num);
            }
        }
        return categoryIds;
    }

    @Override
    public Integer insert(Integer newsId, List<Integer> categoryIds ) {
        Integer num = 0;
        if(categoryIds != null){
            for(Integer categoryId : categoryIds){
                num = newsIdCategoryIdDao.insert(newsId,categoryId);
            }
        }
        return num;
    }

    @Override
    public Integer delete(Integer newsId) {
        return newsIdCategoryIdDao.delete(newsId);
    }
}
