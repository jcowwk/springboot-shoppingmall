package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ProductDto {
    private int product_id;
    private String product_name;
    private String description;
    private int price;
    private int stock_quantity;

    public ProductEntity toEntity() { return new ProductEntity(product_id, product_name, description, price, stock_quantity); }
}