package com.fafu.domain.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.Collection;



public class MyUser extends User {
    private Integer id;
    private String username;
    private ArrayList<Integer> roleId;
    private String token;
    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities,Integer uid,ArrayList<Integer> roleId) {
        super(username, password, authorities);
        this.id = uid;
        this.roleId = roleId;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getRoleId() {
        return roleId;
    }

    public void setRoleId(ArrayList<Integer> roleId) {
        this.roleId = roleId;
    }


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
