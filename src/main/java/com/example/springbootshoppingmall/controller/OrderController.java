package com.example.springbootshoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/order/cart")
    public String cart() {
        return "order/cart";
    }

    @GetMapping("/order/detail")
    public String detail() {
        return "order/detail";
    }
}