package com.fafu.Service.Impl;

import com.fafu.Service.FileService;
import com.fafu.dao.FileDao;
import com.fafu.domain.files.File_Resp;
import com.fafu.domain.files.myFiles;
import com.fafu.until.Packaged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Autowired
    private File_Resp file_resp;

    private Integer num;
    private Integer sum;
    private Map<String,String> map = new HashMap<>();


    @Override
    public File_Resp save_file(List<myFiles> filesList,String path) {
        if(path.equals("soil")){
            save_soil(filesList);
        }else if(path.equals("water")){
            save_water(filesList);
        }else if(path.equals("forest")){
            save_forest(filesList);
        }else if(path.equals("outcome")){
            save_outcome(filesList);
        }else if(path.equals("wetland")){
            save_wetland(filesList);
        }else if(path.equals("bs_soil")){
            save_bs_soil(filesList);
        }else if(path.equals("bs_water")){
            save_bs_water(filesList);
        }else if(path.equals("bs_forest")){
            save_bs_forest(filesList);
        }else if(path.equals("bs_wetland")){
            save_bs_wetland(filesList);
        }else if(path.equals("notice_file")){
            save_notice_file(filesList);
        }else if(path.equals("standard_file")){
            save_standard_file(filesList);
        }else if(path.equals("industry_standard")){
            save_industry_file(filesList);
        }
        file_resp.setMeta(map);
        return file_resp;
    }

    @Override
    public File_Resp save_bs_soil(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_bs_soil_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_bs_water(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_bs_water_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_bs_forest(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_bs_forest_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_bs_wetland(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_bs_wetland_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_soil(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_soil(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_water(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_water(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_forest(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_forest(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_outcome(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_outcome(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    @Override
    public File_Resp save_wetland(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_wetland(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

    public File_Resp save_notice_file(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_notice_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }
    public File_Resp save_standard_file(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_standard_file(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }
    public File_Resp save_industry_file(List<myFiles> filesList) {
        file_resp.setData(new ArrayList<Map<String,String>>());
        sum = 0;
        for(myFiles files : filesList){
            num = fileDao.save_industry_standard(files);
            sum += num;
            if(num <= 0){
                map.put("msg",files.getFileName()+"上传失败");
                map.put("status","500");
            }
            file_resp.getData().add(Packaged.setMyFiles(files));
        }
        if(sum >= filesList.size()){
            map.put("msg","上传成功");
            map.put("status","200");
        }
        return file_resp;
    }

}
