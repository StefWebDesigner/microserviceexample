package com.MicroservicesSpringExample.security;

import com.MicroservicesSpringExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                //ENABLE FOR REACT APPLICATION
                        cors().disable()
                .csrf().disable().
                authorizeRequests().
                //this is the url from the user controller
                        antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .antMatchers(HttpMethod.GET, "/user/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/find").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter())

                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);}

//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10,new SecureRandom());
    }

    //customizing our configuration filter
    protected AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter authenticationFilter=new AuthenticationFilter(authenticationManager());
        //This allows me to give me the login - This is http;//localhost:8080/login
        //dont confuse it with the user login
        authenticationFilter.setFilterProcessesUrl("/login");
//        authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }





}
