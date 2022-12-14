package com.MicroservicesSpringExample.security;

import com.MicroservicesSpringExample.requests.UserLoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager=authenticationManager;

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {

        try {
            //COMES FROM UserLoginRequest WHICH LOGIN THE USER IN
            UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(), new ArrayList<>());

            //MAKES CALLS TO THE LoadUserByUser FROM THE USERSERVER WHICH GETS THE USERNAME
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String email = ( auth.getName());
        String token = Jwts.builder()
                .setSubject(email)
                //REQURIES SECURITY CONSTRANT CLASS
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.Token_Expiration_Time*SecurityConstants.Token_Expiration_Time))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET )
                .compact();


        //One you login, the token knows who you are
        res.getWriter().write("{\"token\": \"" + token + "\", \"role\": \""+ auth.getAuthorities().stream().findFirst().get().getAuthority() + "\", \"id\": \""+ 1 + "\" }");

    }


}
