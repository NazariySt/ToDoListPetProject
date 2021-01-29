package com.softserve.itacademy.controller;

import com.softserve.itacademy.security.PasswordConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final PasswordConfig passwordConfig;

    public LoginController(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login form here");
//        passwordConfig.passwordEncoder().encode("pass");
        return "login";
    }
   /* @GetMapping("/home")
    public String getHome() {
        System.out.println("/home here");
        return "redirect:/home";
    }*/
    /*@PostMapping("/confirm")
    public String login(@PathVariable String username,
                        @PathVariable String password,
                        BindingResult result) {
        System.out.println("here");
        return "home";
    }*/
}
