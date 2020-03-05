package com.fafu.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NewsId_categoryIdDao {
    @Select("select categoryName from news_category where categoryId = #{categoryId}")
    public String find_categoryName(Integer categoryId);

    @Select("select categoryId from news_category where categoryName = #{categoryName}")
    public Integer find_categoryId(String categoryName);

    @Insert("insert into newsid_categoryid values(null,#{newsId},#{categoryId})")
    public Integer insert(Integer newsId,Integer categoryId);

    @Delete("delete from newsid_categoryid where newsId = #{newsId}")
    public Integer delete(Integer newsId);
}
