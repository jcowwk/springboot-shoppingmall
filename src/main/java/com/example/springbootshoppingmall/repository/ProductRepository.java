package com.example.springbootshoppingmall.repository;

import com.example.springbootshoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
