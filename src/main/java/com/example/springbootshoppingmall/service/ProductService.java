package com.example.springbootshoppingmall.service;

import com.example.springbootshoppingmall.dto.ProductDTO;
import com.example.springbootshoppingmall.entity.Product;
import com.example.springbootshoppingmall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            productDTOList.add(ProductDTO.toProductDTO(product));
        }

        return productDTOList;
    }
}
