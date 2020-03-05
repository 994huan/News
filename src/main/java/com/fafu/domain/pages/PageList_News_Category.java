package com.fafu.domain.pages;


import com.fafu.domain.news.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class PageList_News_Category implements Serializable {
    private Long totalPage;
    private Integer pageNum;
    private Integer categoryId;
    private String categoryName;
    private List<News> news;
}
