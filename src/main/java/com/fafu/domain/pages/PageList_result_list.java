package com.fafu.domain.pages;



import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
@Data
@Component
public class PageList_result_list<T> implements Serializable {
    private Long totalPage;
    private Integer pageNum;
    private List<T> list;
}
