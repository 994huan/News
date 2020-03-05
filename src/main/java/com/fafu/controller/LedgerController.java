package com.fafu.controller;

import com.fafu.Service.FileTableService;
import com.fafu.domain.Some_Data_Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedgerController {
    @Autowired
    private FileTableService fileTableService;

    @RequestMapping(path = "/resources/soil",method = RequestMethod.GET)
    public Some_Data_Resp find_soil(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                    @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                    String query){
        return fileTableService.find_file_table(page,row,query,"soil");
    }

    @RequestMapping(path = "/resources/water",method = RequestMethod.GET)
    public Some_Data_Resp find_water(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                     @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                     String query){
        return fileTableService.find_file_table(page,row,query,"water");
    }

    @RequestMapping(path = "/resources/forest",method = RequestMethod.GET)
    public Some_Data_Resp find_forest(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                      @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                      String query){
        return fileTableService.find_file_table(page,row,query,"forest");
    }

    @RequestMapping(path = "/resources/wetland",method = RequestMethod.GET)
    public Some_Data_Resp find_wetland(@RequestParam(name = "pageNum", required = true,defaultValue = "1")Integer page,
                                       @RequestParam(name = "pageSize",required = true,defaultValue = "10")Integer row,
                                       String query){
        return fileTableService.find_file_table(page,row,query,"wetland");
    }
}
