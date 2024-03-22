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
        Member member = Member.toMemberEntity(memberDTO);
        memberRepository.save(member);
    }
}