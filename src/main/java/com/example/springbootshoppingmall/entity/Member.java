package com.example.springbootshoppingmall.entity;

import com.example.springbootshoppingmall.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "member")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String provider;
    private String providerId;

    @Builder
    public Member(String id, String name, String password, String phone, String email, String role, String provider, String providerId) {
        this.id = id;
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
