package com.example.springbootshoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@AllArgsConstructor
@ToString
@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;

    @Column
    private String pw;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
}
