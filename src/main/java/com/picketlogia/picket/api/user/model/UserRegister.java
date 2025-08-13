package com.picketlogia.picket.api.user.model;

import lombok.Getter;

@Getter
public class UserRegister {

    private String email;
    private String password;
    private String nickname;
    private String name;
    private String birth;
    private String gender;
    private String phoneNumber;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .name(name)
                .birth(birth)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .build();
    }
}