package com.softserve.itacademy.securityFromNazar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FilterAutentific extends UsernamePasswordAuthenticationFilter {
    @Autowired
    public FilterAutentific(WebAuthenticationManager webAuthenticationManager) {
        setAuthenticationManager(webAuthenticationManager);
    }

    @Override
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(authentication);
    }
}
