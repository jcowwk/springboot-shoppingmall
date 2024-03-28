package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.Cart;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CartDTO {

    private Long cartId;
    private int quantity;
    private Long member_id;
    private Long product_id;
    private String product_name;
    private BigDecimal product_price;
    private String product_color;
    private String product_size;

    public static CartDTO toCartDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();

        cartDTO.setCartId(cart.getCartId());
        cartDTO.setMember_id(cart.getMember_id());
        cartDTO.setProduct_color(cart.getProduct_color());
        cartDTO.setQuantity(cart.getQuantity());
        cartDTO.setProduct_id(cartDTO.getProduct_id());
        cartDTO.setProduct_name(cartDTO.getProduct_name());
        cartDTO.setProduct_price(cart.getProduct_price());
        cartDTO.setProduct_size(cart.getProduct_size());

        return cartDTO;
    }
}