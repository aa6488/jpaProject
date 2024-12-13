package com.jpaProject.study.user.controller;

import com.jpaProject.study.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String register(@ModelAttribute UserDTO userDTO) {

        System.out.println(userDTO.getUserId());
        System.out.println(userDTO.getUserName());
        System.out.println(userDTO.getUserPwd());



        return null;
    }









}
