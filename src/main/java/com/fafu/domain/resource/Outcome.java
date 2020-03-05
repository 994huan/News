package com.fafu.domain.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outcome implements Serializable {
    private Integer id;
    private String fileName;
    private String username;
    @JsonFormat(pattern = "yyyy-hh-dd hh:mm:ss")
    private Date uploadTime;
}
