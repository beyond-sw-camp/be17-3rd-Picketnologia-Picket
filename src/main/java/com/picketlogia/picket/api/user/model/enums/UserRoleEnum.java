package com.picketlogia.picket.api.user.model.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER"),
    ROLE_SELLER(3, "ROLE_SELLER");

    private final int idx;
    private final String name;

    UserRoleEnum(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }
}
