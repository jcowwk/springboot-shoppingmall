package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.MemberDTO;
import com.example.springbootshoppingmall.dto.ProductDTO;
import com.example.springbootshoppingmall.service.MemberService;
import com.example.springbootshoppingmall.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MemberService memberService;
    private final ProductService productService;

    // 생성자를 통해 productService를 주입받아 productList를 한 번만 초기화
    public HomeController(MemberService memberService, ProductService productService) {
        this.memberService = memberService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        List<ProductDTO> productDTOList = productService.findAll();
        model.addAttribute("productList", productDTOList);
        return "home";
    }

    @GetMapping("member/joinForm")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "redirect:/";
    }

    // 로그인 했을 때만 접근 가능한 페이지 처리
    @GetMapping("member/loginForm")
    public String loginForm(HttpSession session) {
        if (session.getAttribute("loginEmail") == null) {
            return "member/loginForm";
        }
        return "redirect:/";
    }

    // 아이디 유효성 체크
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getEmail());
        }
        return "redirect:/";
    }
}