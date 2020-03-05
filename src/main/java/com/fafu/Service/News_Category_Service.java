package com.fafu.Service;


import java.util.List;

public interface News_Category_Service {
    public String findCategoryName(Integer categoryId);

    public List<Integer> findCategoryId(List<String> categoryNames);

    public Integer insert(Integer newsId,List<Integer> categoryIds);

    public Integer delete(Integer newsId);
}
