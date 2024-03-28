package com.example.springbootshoppingmall.service;

import com.example.springbootshoppingmall.dto.MemberDTO;
import com.example.springbootshoppingmall.entity.Member;
import com.example.springbootshoppingmall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(MemberDTO memberDTO) {
        Optional<Member> byMemberEmail = memberRepository.findByEmail(memberDTO.getEmail());

        if (byMemberEmail.isEmpty()) {
            Member member = Member.toMemberEntity(memberDTO);
            memberRepository.save(member);
        }
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<Member> byMemberEmail = memberRepository.findByEmail(memberDTO.getEmail());

        if (byMemberEmail.isPresent()) {
            Member member = byMemberEmail.get();

            if (member.getPassword().equals(memberDTO.getPassword())) {
                return MemberDTO.toMemberDTO(member);
            }
        }

        return null;
    }

    public Long findByEmail(String loginEmail) {
        Optional<Member> memberOptional = memberRepository.findByEmail(loginEmail);
        return memberOptional.map(Member::getId).orElse(null);
    }
}