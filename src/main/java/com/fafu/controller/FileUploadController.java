package com.fafu.controller;

import com.fafu.Service.FileService;
import com.fafu.domain.Data_resp;
import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.files.File_Resp;
import com.fafu.domain.files.myFiles;
import com.fafu.until.FileUntil;
import com.fafu.until.Judge_Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileUploadController {
    private File_Resp  file_resp;
    @Autowired
    private FileService fileService;
    @Autowired
    private Data_resp data_resp;
    private Map<String,String> map = new HashMap<>();

    //多文件上传
    @RequestMapping(path = "/upload",method = RequestMethod.PUT)
    public File_Resp filesUpload(@RequestParam("file") List<MultipartFile> files, String path) throws FileNotFoundException {

        List<myFiles> filesList = FileUntil.manyUpload(files,path);
        String[] paths = path.split("/");
        return fileService.save_file(filesList,paths[2]);
    }



    //文件下载即单或多
    @RequestMapping(path = "/download",method = RequestMethod.POST)
    public Data_resp fileDownload(String path, @RequestParam(value = "fileNameList",required = true) List<String> fileNameList) throws IOException {
            Integer num = 0;
            String url = null;
            if(fileNameList.size() <=1){
                 url = FileUntil.simpleFileDown(fileNameList.get(0),path);
            }
            else{
                url = FileUntil.packFile(fileNameList,path);
            }
        System.out.println(url);
            Judge_Resp.getMap(map,url,"下载","200");
            data_resp.setMeta(map);
            data_resp.setData(new HashMap<>());
            data_resp.getData().put("file",url);
            return data_resp;
    }


}
