package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productPrice;
    private String productStock;
    private String productColor;
    private String productSize;

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductStock(product.getProductStock());
        productDTO.setProductColor(product.getProductColor());
        productDTO.setProductSize(product.getProductSize());

        return productDTO;
    }
}
