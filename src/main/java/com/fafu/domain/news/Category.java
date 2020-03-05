package com.fafu.domain.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private Integer categoryId;
    private String categoryName;
}
