package com.jpaProject.study.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String homePage() {
        return "board";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }



    @GetMapping("/register")
    public String registerPage() {

        return "register";
    }

    @PostMapping("/register")
    public String register() {

        return "register";
    }









}
