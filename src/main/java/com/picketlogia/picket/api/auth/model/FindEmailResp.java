package com.picketlogia.picket.api.auth.model;

import com.picketlogia.picket.api.user.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindEmailResp {
    private String email;

    public static FindEmailResp from(User user) {
        return FindEmailResp.builder().
                email(user.getEmail())
                .build();
    }
}
