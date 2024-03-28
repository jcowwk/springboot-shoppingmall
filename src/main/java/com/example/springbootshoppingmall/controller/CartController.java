package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.CartDTO;
import com.example.springbootshoppingmall.service.CartService;
import com.example.springbootshoppingmall.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CartController {

    private final CartService cartService;
    private final MemberService memberService;

    public CartController(CartService cartService, MemberService memberService) {
        this.cartService = cartService;
        this.memberService = memberService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cart/list";
    }

    @PostMapping("/cart/put")
    public String cartPut(HttpSession session,
                          @RequestParam("product_id") Long product_id,
                          @RequestParam("product_name") String product_name,
                          @RequestParam("product_price") BigDecimal product_price,
                          @RequestParam("product_color") String product_color,
                          @RequestParam("product_size") String product_size,
                          @RequestParam("quantity") int quantity) {
        if (session.getAttribute("loginEmail") == null) {
            System.out.println(product_id);
            System.out.println(product_name);
            System.out.println(product_price);
            System.out.println(quantity);
            return "member/loginForm";
        }

        String login_Email = (String) session.getAttribute("loginEmail");
        Long member_id = memberService.findByEmail(login_Email);

        CartDTO cartDTO = new CartDTO();

        cartDTO.setProduct_id(product_id);
        cartDTO.setProduct_name(product_name);
        cartDTO.setProduct_price(product_price);
        cartDTO.setProduct_color(product_color);
        cartDTO.setProduct_size(product_size);
        cartDTO.setQuantity(quantity);
        cartDTO.setMember_id(member_id);

        cartService.addToCart(cartDTO);
        return "redirect:/cart";
    }
}