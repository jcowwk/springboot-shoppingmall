package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.entity.ProductEntity;
import com.example.springbootshoppingmall.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) { this.productRepository = productRepository; }

    @GetMapping("/productpage")
    public String ProductPage(Model model) {
        List<ProductEntity> productEntityList = (List<ProductEntity>)
                productRepository.findAll();

        model.addAttribute("productList", productEntityList);
        return "product/productpage";
    }

    @GetMapping("/allpage")
    public String AllPage(Model model) {
        return "product/allpage";
    }

    @GetMapping("/newpage")
    public String NewPage(Model model) {
        return "product/newpage";
    }
}
