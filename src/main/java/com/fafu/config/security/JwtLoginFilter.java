package com.fafu.config.security;



import com.fafu.domain.Some_Data_Resp;
import com.fafu.domain.user.MyUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    private Some_Data_Resp datas = new Some_Data_Resp();

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
        super.setAuthenticationFailureHandler(new LoginUserFailHandler());

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null)
            username = "";
        if(password == null)
            password = "";
        username = username.trim();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password,new ArrayList<>());
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder().setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis()+60*60*24*1000))
                .signWith(SignatureAlgorithm.HS512,"MyJwtSecret")
                .compact();
        response.setContentType("application/json;charset=utf-8");

        response.addHeader("token","Bearer"+token);


        MyUser myUser = (MyUser) authResult.getPrincipal();
        Map<String,String> meta = new HashMap<>();

        meta.put("status","200");
        meta.put("msg","登录成功");
        datas.setMeta(meta);
        myUser.setToken("Bearer"+token);
        datas.setData(myUser);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(datas));
    }
}
