package com.softserve.itacademy.controller;

import com.softserve.itacademy.security.PasswordConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final PasswordConfig passwordConfig;

    public LoginController(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    @GetMapping("/login-form")
    public String login() {
//        passwordConfig.passwordEncoder().encode("pass");
        return "login-page";
    }

    @PostMapping("/")
    public String pLogin() {
        return "home";
    }
}
