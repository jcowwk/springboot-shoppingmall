package com.example.springbootshoppingmall.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String showCart() {
        return "cart/list";
    }

    @PostMapping("/cart/put")
    public String cartPut(HttpSession session) {
        if (session.getAttribute("loginEmail") == null) {
            return "member/loginForm";
        }
        return "redirect:/cart";
    }
}