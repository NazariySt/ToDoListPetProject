package com.softserve.itacademy.security;

import com.softserve.itacademy.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final long id;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> rols;

    public SecurityUser(long id,
                        String email,
                        String password,
                        Collection<? extends GrantedAuthority> rols) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rols = rols;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static SecurityUser create(User user) {
        List<GrantedAuthority> rols = Collections.singletonList(new SimpleGrantedAuthority( user.getRole().getName()));
        return new SecurityUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                rols);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rols;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}