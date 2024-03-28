package com.example.springbootshoppingmall.service;

import com.example.springbootshoppingmall.dto.CartDTO;
import com.example.springbootshoppingmall.entity.Cart;
import com.example.springbootshoppingmall.repository.CartRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Service
public class CartService {
    private final CartRepository cartRepository;

    public void addToCart(CartDTO cartDTO) {
        Cart cart = Cart.toCartEntity(cartDTO);
        cartRepository.save(cart);
    }
}