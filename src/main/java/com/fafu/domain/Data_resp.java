package com.fafu.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Data
@Component
public class Data_resp implements Serializable {
    private Map<String,String> data;
    private Map<String,String> meta;
}
