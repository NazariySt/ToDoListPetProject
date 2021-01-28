package com.softserve.itacademy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final MainUserService mainUserService;

    @Autowired
    public WebSecurityConfigurer(PasswordEncoder passwordEncoder, MainUserService mainUserService) {
        this.passwordEncoder = passwordEncoder;
        this.mainUserService = mainUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic()
                .formLogin()

                .loginPage("/login-form")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login-form?error=true")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/perform-logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login-form");

        }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(mainUserService);
        return provider;
    }
}
