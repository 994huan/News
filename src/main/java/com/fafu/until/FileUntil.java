package com.fafu.until;

import com.fafu.domain.files.myFiles;
import com.fafu.domain.user.MyUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUntil {
    private static myFiles myfiles;
    private static String myurl ="http://localhost:80";
 //单文件上传
   public static myFiles simpleUpload(MultipartFile file,String path) throws FileNotFoundException {

       myfiles = new myFiles();
        if(file.isEmpty()){
            return null;
        }
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String fileName = file.getOriginalFilename();
        String[] fileNames = fileName.split("\\.");
        int size = (int) file.getSize();
        String real = System.getProperty("user.dir");

        String imgPath = path;
        String realpath = real+path+fileName;
       System.out.println(realpath);
        File dest = new File(realpath);
        int count = 0;
        while (dest.exists()) {
            count++;
            dest = new File(real+path+"/"+fileNames[0]+"("+count+")."+fileNames[1]);
        }
        if(count!=0)
            fileName = fileNames[0]+"("+count+")."+fileNames[1];
        myfiles.setFileName(fileName);
        myfiles.setUploadTime(new Date());
        myfiles.setFilePath("/img"+"/"+fileName);
        myfiles.setUsername(username);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return myfiles;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

//多文件上传
    public static List<myFiles> manyUpload(List<MultipartFile> files,String path) throws FileNotFoundException {
        if(files.isEmpty()){
            return null;
        }

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String imgPath = path;

        String real = System.getProperty("user.dir");

        path = real + path;
        System.out.println("\n\n\n"+real+"\n\n\n");
        List<myFiles> filesList = new ArrayList<>();


        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            String[] fileNames = fileName.split("\\.");
            if(fileNames.length > 2){
                for(int i = 1; i < fileNames.length-1;i++){
                    fileNames[0] = fileNames[0]+"."+fileNames[i];
                }
            }
            myfiles = new myFiles();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if(file.isEmpty()){
                return null;
            }else{
                File dest = new File(path+"/"+fileName);
                int count = 0;
                while (dest.exists()) {
                    count++;
                    dest = new File(path+"/"+fileNames[0]+"("+count+")."+fileNames[fileNames.length-1]);
                }
                if(count!=0)
                    fileName = fileNames[0]+"("+count+")."+fileNames[fileNames.length-1];
                myfiles.setFileName(fileName);
                myfiles.setFilePath(imgPath + "/" + fileName);
                myfiles.setUploadTime(new Date());
                myfiles.setUsername(username);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                    filesList.add(myfiles);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return filesList;
    }
    //文件删除
    public static boolean deleteFile(String path){
       if(path == null || path.equals("") || !path.contains("/")){
           return true;
       }
       String realpath = System.getProperty("user.dir");
       File file = new File(realpath+path);
       if(file.exists()){
           if(file.delete()){
                return true;
           }else{
                return false;
           }
       }
       return true;
    }
    //单文件下载
    public static String simpleFileDown(String fileName, String path) {
        if(fileName != null) {
            String real = System.getProperty("user.dir") + path + "/" + fileName;
            String[] paths = path.split("/");
            File file = new File(real);
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            if(file.exists()){
                return myurl+"/download/"+paths[2]+"/"+fileName;
            }
        }
        return null;
    }
    //多文件打包
    public static String packFile(List<String> fileNameList,String path){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String real = System.getProperty("user.dir")+"/resources/zip";
        File file = new File(real);
        if(!file.isDirectory() && !file.exists()){
            file.mkdirs();
        }

        String zipName = UUID.randomUUID().toString()+".zip";
        String zipPath = real+"/"+zipName;
        File zipfile = new File(zipPath);
        ZipOutputStream zipOutputStream = null;
        FileInputStream fis = null;
        BufferedInputStream bufferedInputStream = null;
        try{
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipfile));
            String realfile = System.getProperty("user.dir")+path;
            for(String fileName : fileNameList){
                File imgfile = new File(realfile+"/"+fileName);
                if(imgfile.exists()){
                    fis = new FileInputStream(imgfile);
                    ZipEntry zipEntry = new ZipEntry(fileName);
                    zipOutputStream.putNextEntry(zipEntry);
                    bufferedInputStream = new BufferedInputStream(fis);
                    int len = 0;
                    byte[] bytes = new byte[1024 * 10];
                    while((len = bufferedInputStream.read(bytes)) != -1){
                        zipOutputStream.write(bytes,0,len);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bufferedInputStream!=null){
                    bufferedInputStream.close();
                }
                if(fis!=null){
                    fis.close();
                }
                if(zipOutputStream!=null){
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(zipfile.exists()){
            String url = simpleFileDown(zipName,"/resources/zip");
            return url;
        }
        return null;
    }
}
