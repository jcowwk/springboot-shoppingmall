package com.example.springbootshoppingmall.entity;

import com.example.springbootshoppingmall.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

@Table(name = "member")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String role;
    @Column
    private String provider;
    @Column
    private String providerId;

    @Builder
    public Member(String name, String password, String phone, String email, String role, String provider, String providerId) {
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public static Member toMemberEntity(MemberDTO memberDTO) {
        Member member = new Member();

        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setName(memberDTO.getName());

        return member;
    }
}
