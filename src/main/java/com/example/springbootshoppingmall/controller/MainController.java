package com.example.springbootshoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/jcowwk")
    public String Main(){
        return "main";
    }

    @GetMapping("/login")
    public String Login(){
        return "user/login";
    }

    @GetMapping("/join")
    public String Join(){
        return "user/join";
    }
}