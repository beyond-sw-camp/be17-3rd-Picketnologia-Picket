package com.picketlogia.picket.api.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginResp {

    private Long idx;
    private String nickname;
    private String role;

    public static UserLoginResp from(UserAuth authUser) {
        return UserLoginResp.builder()
                .idx(authUser.getIdx())
                .nickname(authUser.getNickname())
                .role(authUser.getRole())
                .build();
    }
}
