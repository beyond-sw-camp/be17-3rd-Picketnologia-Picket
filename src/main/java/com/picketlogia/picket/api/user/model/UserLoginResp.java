package com.picketlogia.picket.api.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginResp {

    private Long id;

    private String email;
    private String nickname;

    public static UserLoginResp from(UserAuth authUser) {
        return UserLoginResp.builder()
                .id(authUser.getId())
                .email(authUser.getEmail())
                .build();
    }
}
