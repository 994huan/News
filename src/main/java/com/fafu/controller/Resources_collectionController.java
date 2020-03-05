package com.fafu.controller;

import com.fafu.Service.FileTableService;
import com.fafu.domain.Some_Data_Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resources_collectionController {
    @Autowired
    private FileTableService fileTableService;

    @RequestMapping(path = "/resources/notice_file",method = RequestMethod.GET)
    public Some_Data_Resp find_notice_file(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                           @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                           String query){
        return fileTableService.find_file_table(page,row,query,"notice_file");
    }
    @RequestMapping(path = "/resources/standard_file",method = RequestMethod.GET)
    public Some_Data_Resp find_standard_file(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                             @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                             String query){
        return fileTableService.find_file_table(page,row,query,"standard_file");
    }
    @RequestMapping(path = "/resources/industry_standard",method = RequestMethod.GET)
    public Some_Data_Resp find_industry_standard(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                                 @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                                 String query){
        return fileTableService.find_file_table(page,row,query,"industry_standard");
    }
}
