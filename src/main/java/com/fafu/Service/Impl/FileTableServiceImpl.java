package com.fafu.Service.Impl;

import com.fafu.Service.FileTableService;
import com.fafu.dao.FileDao;
import com.fafu.domain.Ledger.Ledger_Files;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.balanceSheet.Bs_Files;
import com.fafu.domain.collection.Collection_Files;
import com.fafu.domain.pages.*;
import com.fafu.domain.resource.*;
import com.fafu.until.Judge_Resp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FileTableServiceImpl implements FileTableService {
    @Autowired
    private FileDao fileDao;
    @Autowired
    private Some_Data_Resp someDataResp;
    @Autowired
    private PageList_result_list pageList_result_list;

    private Map<String,String> map = new HashMap<>();
    @Override
    public Some_Data_Resp find_file_table(Integer page, Integer rows, String query, String path) {
        query = Judge_Resp.getquery(query);
        if(path.equals("soil")){
             return find_soil(rows,query,page);
        }else if(path.equals("water")){
            return find_water(rows,query,page);
        }else if(path.equals("forest")){
            return find_forest(rows,query,page);
        }else if(path.equals("outcome")){
            return  find_outcome(rows,query,page);
        }else if(path.equals("wetland")){
            return find_wetland(rows,query,page);
        }else if(path.equals("bs_soil")){
            return find_bs_soil(rows,query,page);
        }else if(path.equals("bs_water")){
            return find_bs_water(rows,query,page);
        }else if(path.equals("bs_wetland")){
            return find_bs_wetland(rows,query,page);
        }else if(path.equals("bs_forest")){
            return find_bs_forest(rows,query,page);
        }else if (path.equals("notice_file")){
            return find_notice_file(rows,query,page);
        }else if (path.equals("standard_file")){
            return find_standard_file(rows,query,page);
        }else if (path.equals("industry_standard")){
            return find_industry_standard(rows,query,page);
        }
        return null;
    }
    public Some_Data_Resp find_soil(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Ledger_Files> ledger_files = fileDao.find_soil(query);
        Judge_Resp.getMap(map,ledger_files,"获取","200");
        PageInfo<Ledger_Files> pageInfo = new PageInfo<>(ledger_files);
        pageList_result_list.setList(ledger_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_water(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Ledger_Files> ledger_files =  fileDao.find_water(query);
        Judge_Resp.getMap(map,ledger_files,"获取","200");
        PageInfo<Ledger_Files> pageInfo = new PageInfo<>(ledger_files);
        pageList_result_list.setList(ledger_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_forest(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Ledger_Files> ledger_files = fileDao.find_forest(query);
        Judge_Resp.getMap(map,ledger_files,"获取","200");
        PageInfo<Ledger_Files> pageInfo = new PageInfo<>(ledger_files);
        pageList_result_list.setList(ledger_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_outcome(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Outcome> outcomes = fileDao.find_outcome(query);
        Judge_Resp.getMap(map,outcomes,"获取","200");
        PageInfo<Outcome> pageInfo = new PageInfo<>(outcomes);
        pageList_result_list.setList(outcomes);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_wetland(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Ledger_Files> ledger_files = fileDao.find_wetland(query);
        Judge_Resp.getMap(map,ledger_files,"获取","200");
        PageInfo<Ledger_Files> pageInfo = new PageInfo<>(ledger_files);
        pageList_result_list.setList(ledger_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_notice_file(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Collection_Files> collection_files = fileDao.find_notice_file(query);
        Judge_Resp.getMap(map,collection_files,"获取","200");
        PageInfo<Collection_Files> pageInfo = new PageInfo<>(collection_files);
        pageList_result_list.setList(collection_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_standard_file(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Collection_Files> collection_files = fileDao.find_standard_file(query);
        Judge_Resp.getMap(map,collection_files,"获取","200");
        PageInfo<Collection_Files> pageInfo = new PageInfo<>(collection_files);
        pageList_result_list.setList(collection_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_industry_standard(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Collection_Files> collection_files = fileDao.find_industry_standard(query);
        Judge_Resp.getMap(map,collection_files,"获取","200");
        PageInfo<Collection_Files> pageInfo = new PageInfo<>(collection_files);
        pageList_result_list.setList(collection_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_bs_soil(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Bs_Files> bs_files = fileDao.bs_find_soil(query);
        Judge_Resp.getMap(map,bs_files,"获取","200");
        PageInfo<Bs_Files> pageInfo = new PageInfo<>(bs_files);
        pageList_result_list.setList(bs_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_bs_water(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Bs_Files> bs_files =  fileDao.bs_find_water(query);
        Judge_Resp.getMap(map,bs_files,"获取","200");
        PageInfo<Bs_Files> pageInfo = new PageInfo<>(bs_files);
        pageList_result_list.setList(bs_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_bs_forest(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Bs_Files> bs_files = fileDao.bs_find_forest(query);
        Judge_Resp.getMap(map,bs_files,"获取","200");
        PageInfo<Bs_Files> pageInfo = new PageInfo<>(bs_files);
        pageList_result_list.setList(bs_files);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
    public Some_Data_Resp find_bs_wetland(Integer rows, String query,Integer page){
        PageHelper.startPage(page,rows);
        List<Bs_Files> bs_filess = fileDao.bs_find_wetland(query);
        Judge_Resp.getMap(map,bs_filess,"获取","200");
        PageInfo<Bs_Files> pageInfo = new PageInfo<>(bs_filess);
        pageList_result_list.setList(bs_filess);
        pageList_result_list.setTotalPage(pageInfo.getTotal());
        pageList_result_list.setPageNum(pageInfo.getPageNum());
        someDataResp.setData(pageList_result_list);
        someDataResp.setMeta(map);
        return someDataResp;
    }
}
