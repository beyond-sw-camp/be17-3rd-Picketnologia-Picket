package com.picketlogia.picket.api.user.model;

import lombok.Getter;

@Getter
public class UserRegister {

    private String email;
    private String password;
    private String nickname;
    private String name;
    private String birthday;
    private String gender;
    private String contact;

    public User from() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .name(name)
                .birthday(birthday)
                .gender(gender)
                .contact(contact)
                .build();
    }
}
