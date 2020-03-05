package com.fafu.domain.news;

import com.fafu.until.Date_String;
import com.fafu.until.String_List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    private Integer newsId;
    private String title;
    private String author;
    private String editor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
    private String source;
    private String imgpath;
    private String content;
    private String categoryName;

    public void setReleaseTime(String str) throws ParseException {
        releaseTime = Date_String.string_date("yyyy-hh-dd",str);
    }

    public void setUpdateTime(String str) throws ParseException {
        if(!str.contains("-")){
            System.out.println("666");
            updateTime = null;
        }else{
            System.out.println("str:"+str);
            updateTime = Date_String.string_date("yyyy-hh-dd hh:mm:ss",str);
        }

    }


}
