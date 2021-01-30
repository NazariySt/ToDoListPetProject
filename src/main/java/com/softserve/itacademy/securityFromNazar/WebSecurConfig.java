package com.softserve.itacademy.securityFromNazar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class WebSecurConfig extends WebSecurityConfigurerAdapter {
    private FilterAutentific webAuthenticationFilter;

    @Autowired
    public void setWebAuthenticationFilter(FilterAutentific webAuthenticationFilter) {
        this.webAuthenticationFilter = webAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().permitAll();
        http.addFilterBefore(webAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
