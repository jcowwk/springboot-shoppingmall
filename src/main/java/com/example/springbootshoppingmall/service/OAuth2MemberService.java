package com.example.springbootshoppingmall.service;

import com.example.springbootshoppingmall.entity.GoogleMemberInfo;
import com.example.springbootshoppingmall.entity.Member;
import com.example.springbootshoppingmall.entity.NaverMemberInfo;
import com.example.springbootshoppingmall.entity.OAuth2MemberInfo;
import com.example.springbootshoppingmall.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuth2MemberService extends DefaultOAuth2UserService {
    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2MemberInfo memberInfo = null;

        String registerationId = userRequest.getClientRegistration().getRegistrationId();

        if (registerationId.equals("google")) {
            memberInfo = new GoogleMemberInfo(oAuth2User.getAttributes());
        }
        else if (registerationId.equals("naver")) {
            memberInfo = new NaverMemberInfo((Map) oAuth2User.getAttributes().get("response"));
        }
        else {
            System.out.println("로그인 실패");
        }

        String provider = memberInfo.getProvider();
        String providerId = memberInfo.getProviderId();
        String name = memberInfo.getName();
        String email = memberInfo.getEmail();
        String phone = memberInfo.getPhone();

        String role = "ROLE_MEMBER";

        // 이메일로 찾기
        Optional<Member> findMember = memberRepository.findByEmail(email);

        Member member = null;
        if (findMember.isEmpty()) {
            member = Member.builder()
                    .name(name)
                    .email(email)
                    .password(encoder.encode("password"))
                    .phone(phone)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();

            memberRepository.save(member);
        }
        else {
            member = findMember.get();
        }

        return new PrincipalDetails(member, oAuth2User.getAttributes());
    }
}