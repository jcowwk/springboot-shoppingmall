package com.example.springbootshoppingmall.entity;


import java.util.Map;

public class NaverMemberInfo implements OAuth2MemberInfo {

    private Map<String, Object> attributes;
    public NaverMemberInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getProviderId() {
        return (String) attributes.get("id");
    }

    public String getProvider() {
        return "naver";
    }

    public String getName() {
        return (String) attributes.get("name");
    }

    public String getEmail() {
        return (String) attributes.get("email");
    }

    public String getRole() {
        return (String) attributes.get("role");
    }

    public String getPhone() {
        return (String) attributes.get("phone");
    }
}
