package com.example.springbootshoppingmall.entity;

import com.example.springbootshoppingmall.dto.CartDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cart")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column
    private int quantity;
    @Column
    private Long member_id;
    @Column
    private Long product_id;
    @Column
    private String product_name;
    @Column
    private BigDecimal product_price;
    @Column
    private String product_color;
    @Column
    private String product_size;

    public static Cart toCartEntity(CartDTO cartDTO) {
        Cart cart = new Cart();

        cart.setMember_id(cartDTO.getMember_id());
        cart.setProduct_color(cartDTO.getProduct_color());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setProduct_id(cartDTO.getProduct_id());
        cart.setProduct_price(cartDTO.getProduct_price());
        cart.setProduct_size(cartDTO.getProduct_size());
        cart.setProduct_name(cartDTO.getProduct_name());

        return cart;
    }
}