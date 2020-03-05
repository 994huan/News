package com.fafu.domain.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News_Resp implements Serializable {
    private Integer newsId;
    private String title;
    private String author;
    private String editor;
    @JsonFormat(pattern = "yyyy-hh-dd")
    private Date releaseTime;
    @JsonFormat(pattern = "yyyy-hh-dd hh:mm:ss")
    private Date updateTime;
    private String source;
    private String imgpath;
    private String content;
    private List<String> categoryName;
}
