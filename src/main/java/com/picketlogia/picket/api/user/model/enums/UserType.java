package com.picketlogia.picket.api.user.model.enums;

import lombok.Getter;

@Getter
public enum UserType {
    NORMAL("일반 회원"),
    SELLER("판매자 회원");

    private final String description;

    UserType(String description) {
        this.description = description;
    }
}
