package com.fafu.dao;

import com.fafu.domain.Ledger.Ledger_Files;
import com.fafu.domain.balanceSheet.Bs_Files;
import com.fafu.domain.collection.Collection_Files;
import com.fafu.domain.files.myFiles;
import com.fafu.domain.resource.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileDao {
    //以下是各个资源表的增查
    @Insert("insert into soil_file values(null, #{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_soil(  myFiles myFiles);

    @Insert("insert into forest_file values(null, #{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_forest(myFiles myFiles);

    @Insert("insert into outcome_file values(null, #{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_outcome(myFiles myFiles);

    @Insert("insert into water_file values(null, #{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_water(myFiles myFiles);

    @Insert("insert into wetland_file values(null, #{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_wetland(myFiles myFiles);


    @Insert("insert into notice_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_notice_file(myFiles myFiles);

    @Insert("insert into standard_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_standard_file(myFiles myFiles);

    @Insert("insert into industry_standard values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_industry_standard(myFiles myFiles);

    @Insert("insert into bs_soil_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_bs_soil_file(myFiles myFiles);

    @Insert("insert into bs_water_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_bs_water_file(myFiles myFiles);

    @Insert("insert into bs_wetland_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_bs_wetland_file(myFiles myFiles);

    @Insert("insert into bs_forest_file values(null,#{fileName},#{username},#{uploadTime})")
    @Options(useGeneratedKeys = true,keyProperty = "fid")
    public Integer save_bs_forest_file(myFiles myFiles);






    @Select("select * from soil_file where fileName like #{query}")
    public List<Ledger_Files> find_soil(String query);

    @Select("select * from forest_file where fileName like #{query}")
    public List<Ledger_Files> find_forest(String query);

    @Select("select * from outcome_file where fileName like #{query}")
    public List<Outcome> find_outcome(String query);

    @Select("select * from water_file where fileName like #{query}")
    public List<Ledger_Files> find_water(String query);

    @Select("select * from wetland_file where fileName like #{query}")
    public List<Ledger_Files> find_wetland(String query);

    @Select("select * from notice_file where fileName like #{query}")
    public List<Collection_Files> find_notice_file(String query);

    @Select("select * from standard_file where fileName like #{query}")
    public List<Collection_Files> find_standard_file(String query);

    @Select("select * from industry_standard where fileName like #{query}")
    public List<Collection_Files> find_industry_standard(String query);

    @Select("select * from bs_soil_file where fileName like #{query}")
    public List<Bs_Files> bs_find_soil(String query);

    @Select("select * from bs_forest_file where fileName like #{query}")
    public List<Bs_Files> bs_find_forest(String query);

    @Select("select * from bs_water_file where fileName like #{query}")
    public List<Bs_Files> bs_find_water(String query);

    @Select("select * from bs_wetland_file where fileName like #{query}")
    public List<Bs_Files> bs_find_wetland(String query);
}
