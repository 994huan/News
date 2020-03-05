package com.fafu.config;


import com.fafu.config.security.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private myUserDetailsService myUserDetailsService;
    @Autowired
    @Qualifier("myUserFailHandler")
    private LoginUserFailHandler userFailHandler;
    @Autowired
    @Qualifier("myLoginAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便
        http.cors().and().csrf().disable()
                .authorizeRequests().antMatchers("/","/home","/login","/news/all_category","/news/{newsId}","/news/category/{categoryId}","/img/*","/balance_sheet/*","/outcome/*","/soil/*","/water/*","/wetland/*","/forest/*","/notice_file/*","/standard_file/*","/industry_standard/*","/zip/*").permitAll()
                                .antMatchers("/favicon.ico").permitAll()
                                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .formLogin()
                .loginPage("/home")
                .loginProcessingUrl("/login")
                .failureHandler(userFailHandler)

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)


                .and()
                .addFilterBefore(new JwtLoginFilter("/login",authenticationManager()),UsernamePasswordAuthenticationFilter.class)
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));

    }
}
