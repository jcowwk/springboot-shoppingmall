package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long memberNum;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String role;
    private String provider;
    private String providerId;

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberNum(member.getMemberNum());
        memberDTO.setId(member.getId());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setName(member.getName());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setRole(member.getRole());
        memberDTO.setProvider(member.getProvider());
        memberDTO.setProviderId(member.getProviderId());

        return memberDTO;
    }
}
