package com.example.springbootshoppingmall.entity;

import com.example.springbootshoppingmall.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String productName;
    @Column
    private String productPrice;
    @Column
    private String productStock;
    @Column
    private String productColor;
    @Column
    private String productSize;
}
