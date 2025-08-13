package com.picketlogia.picket.api.user.model.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {
    ACTIVE(1,"ACTIVE"),
    SUSPEND(2, "SUSPEND"),
    DELETE(3, "DELETE");

    private final String value;
    private final int idx;

    UserStatusEnum(int idx, String name) {
        this.idx = idx;
        this.value = name;
    }
}
