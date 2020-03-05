package com.fafu.domain.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class Role_res {
    private List<Role> list;
}
