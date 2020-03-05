package com.fafu.domain.pages;

import com.fafu.domain.news.News;
import com.fafu.domain.news.News_Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PageList_News implements Serializable {
    private Long totalPage;
    private int pageNum;
    private List<News_Resp> news;
}
