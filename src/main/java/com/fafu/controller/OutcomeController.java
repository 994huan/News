package com.fafu.controller;

import com.fafu.Service.FileTableService;
import com.fafu.domain.Some_Data_Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutcomeController {
    @Autowired
    private FileTableService fileTableService;
    //以下各个资源表的查询接口
    @RequestMapping(path = "/resources/outcome",method = RequestMethod.GET)
    public Some_Data_Resp find_outcome(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                       @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                       String query){
        return fileTableService.find_file_table(page,row,query,"outcome");
    }


}