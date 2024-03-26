package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.MemberDTO;
import com.example.springbootshoppingmall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Builder
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("member/joinForm")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "home";
    }

    // 로그인 했을 떄만 접근 가능한 페이지 처리
    @GetMapping("member/loginForm")
    public String loginForm(HttpSession session) {
        if (session.getAttribute("loginEmail") == null) {
            return "member/loginForm";
        }
        return "home";
    }

    // 아이디 유효성 체크
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getEmail());
            return "home";
        } else {
            return "member/loginForm";
        }
    }
}