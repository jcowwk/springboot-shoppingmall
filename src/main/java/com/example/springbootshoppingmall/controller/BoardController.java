package com.example.springbootshoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("board/review/list")
    public String review() {
        return "board/review/list";
    }

    @GetMapping("board/qna/list")
    public String qna() {
        return "board/qna/list";
    }

    @GetMapping("board/notice/list")
    public String notice() {
        return "board/notice/list";
    }
}