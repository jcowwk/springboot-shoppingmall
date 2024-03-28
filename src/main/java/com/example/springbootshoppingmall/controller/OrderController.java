package com.example.springbootshoppingmall.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String showOrder() {
        return "order/list";
    }

    @PostMapping("/order/put")
    public String orderPut(HttpSession session) {
        if (session.getAttribute("loginEmail") == null) {
            return "member/loginForm";
        }
        return "redirect:/order";
    }

    @PostMapping("/order/sheet")
    public String orderSheet() {
        return "order/sheet";
    }
}