package com.fafu.domain.files;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Component
public class File_Resp implements Serializable {
    private List<Map<String,String>> data;
    private Map<String,String> meta;
}
