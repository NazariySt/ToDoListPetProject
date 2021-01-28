package com.softserve.itacademy.security;

import com.softserve.itacademy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainUser implements UserDetails {

    private final long id;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> rols;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public MainUser(long id,
                    String email,
                    String password,
                    Collection<? extends GrantedAuthority> rols,
                    boolean isAccountNonExpired,
                    boolean isAccountNonLocked,
                    boolean isCredentialsNonExpired,
                    boolean isEnabled) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rols = rols;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public static MainUser create(User user) {
        List<GrantedAuthority> rols = Collections.emptyList();
        return new MainUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                rols,
                true,
                true,
                true,
                true);
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
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
