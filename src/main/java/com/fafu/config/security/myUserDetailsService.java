package com.fafu.config.security;

import com.fafu.Service.UserService;
import com.fafu.domain.user.MyUser;
import com.fafu.domain.user.Role;
import com.fafu.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class myUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUser(s);
        if (user ==null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            String RoleName = role.getIdentity();
            authorities.add(new SimpleGrantedAuthority("ROLE_"+RoleName));
        }
        return new MyUser(user.getUsername(),passwordEncoder.encode(user.getPassword()),authorities,user.getUid(),user.getRoleId());
    }
}
