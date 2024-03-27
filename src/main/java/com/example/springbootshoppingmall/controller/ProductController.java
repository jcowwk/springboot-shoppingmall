package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.ProductDTO;
import com.example.springbootshoppingmall.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Builder
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/list")
    public String productList(Model model) {
        List<ProductDTO> productDTOList = productService.findAll();
        model.addAttribute("productList", productDTOList);
        return "product/list";
    }

    @GetMapping("/product/detail/{productId}")
    public String productDetail(@PathVariable Long productId, Model model, HttpSession session) {
        ProductDTO productDTO = productService.findById(productId);
        session.setAttribute("selectProductId", productId);
        model.addAttribute("productDetail", productDTO);
        return "product/detail";
    }
}