package com.fafu.dao;

import com.fafu.domain.news.Category;
import com.fafu.domain.news.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface NewDao {
    //查询所有
    @Select("select * from news where title like #{query}")
    public List<News> findAll(Integer page, Integer row,String query);

    @Select("select * from news where newsId = #{newsId}")
    public News findNewsId(Integer newsId);

    @Select("select * from news_category")
    public  List<Category> findAll_category();


    @Select("select * from news where title like #{query} and newsId in ( select newsId from newsid_categoryid where categoryId = #{id})"
            )
    public List<News> findAll_News_category( String query,@Param("id") Integer cagetoryid);



    @Insert("insert into news(newsId,title,author,editor,releaseTime,source,imgpath,content,categoryName) values(null,#{title},#{author},#{editor},#{releaseTime},#{source}," +
            "#{imgpath},#{content},#{categoryName})")
    @Options(useGeneratedKeys = true,keyProperty = "newsId")
    public Integer insert(News news);


    @Delete("delete from news where newsId = #{newsId}")
    public Integer delete(Integer newsId);

    @Update("update news set title = #{title},Author = #{author},editor = #{editor},updateTime=#{updateTime} ,source = #{source}," +
            "imgpath = #{imgpath},content = #{content},categoryName = #{categoryName} where newsId = #{newsId} ")
    public Integer update(News news);

    @Update("update news set imgpath = #{imgpath} where newsId = #{newsId}")
    public Integer updateImg(Integer newsId,String imgpath);

}
