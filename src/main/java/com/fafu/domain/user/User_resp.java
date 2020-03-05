package com.fafu.domain.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User_resp {
    private Integer uid;
    private String username;
}
