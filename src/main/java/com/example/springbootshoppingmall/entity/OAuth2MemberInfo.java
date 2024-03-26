package com.example.springbootshoppingmall.entity;

public interface OAuth2MemberInfo {
    String getProviderId();
    String getProvider();
    String getName();
    String getEmail();
    String getPhone();
    String getRole();
}