package com.picketlogia.picket.api.user.model.dto.login;

import com.picketlogia.picket.api.user.model.dto.UserAuth;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserLoginResp {

    private Long idx;
    private String nickname;
    private String role;
    private String userType;

    public static UserLoginResp from(UserAuth authUser) {
        return UserLoginResp.builder()
                .idx(authUser.getIdx())
                .nickname(authUser.getNickname())
                .role(authUser.getRole())
                .userType(authUser.getUserType())
                .build();
    }
}
