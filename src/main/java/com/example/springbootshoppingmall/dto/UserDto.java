package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDto {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;

    public UserEntity toEntity() {
        return new UserEntity(id, pw, name, email, phone);
    }
}
