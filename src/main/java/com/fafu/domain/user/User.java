package com.fafu.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {

    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String identity;
    private List<Role> roles;
    private ArrayList<Integer> roleId;
    private String token;

}
