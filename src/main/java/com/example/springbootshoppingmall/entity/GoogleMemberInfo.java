package com.example.springbootshoppingmall.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

public class GoogleMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;

    public GoogleMemberInfo(Map<String, Object> attributes) { this.attributes = attributes; }

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }
    @Override
    public String getProvider() {
        return "google";
    }
    @Override
    public String getRole() { return (String) attributes.get("role"); }
    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }
    @Override
    public String getPhone() {
        return (String) attributes.get("phone");
    }
}