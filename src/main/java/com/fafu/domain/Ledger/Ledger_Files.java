package com.fafu.domain.Ledger;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Ledger_Files implements Serializable {
    private Integer id;
    private String fileName;
    private String username;
    @JsonFormat(pattern = "yyyy-hh-dd hh:mm:ss")
    private Date uploadTime;
}
