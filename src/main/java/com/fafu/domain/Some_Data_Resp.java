package com.fafu.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Data
@Component
public class Some_Data_Resp<T> implements Serializable {
    private T data;
    private Map<String,String> meta;
}
