package com.fafu.domain.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Data
@Component
public class User_login implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String identity;
}
