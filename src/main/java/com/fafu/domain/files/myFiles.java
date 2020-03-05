package com.fafu.domain.files;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class myFiles implements Serializable {
    private Integer fid;
    private String fileName;
    private String filePath;
    @JsonFormat(pattern = "YYYY-HH-dd hh-mm-ss")
    private Date uploadTime;
    private String username;
}
