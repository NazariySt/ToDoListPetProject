package com.softserve.itacademy.security;

import org.springframework.security.core.GrantedAuthority;

public class MainRole implements GrantedAuthority {
    private long id;
    private String aurhority;
    @Override
    public String getAuthority() {
        return null;
    }
}
