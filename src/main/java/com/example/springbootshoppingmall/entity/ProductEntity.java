package com.example.springbootshoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product")
@AllArgsConstructor
@ToString
@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class ProductEntity {
    @Id
    private int product_id;

    @Column
    private String product_name;
    @Column
    private String description;
    @Column
    private int price;
    @Column
    private int stock_quantity;
}