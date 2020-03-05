package com.fafu.domain.news;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Data
@Component
public class Category_Resp implements Serializable {
    private Integer count;
    private List<Category> categories;
}
