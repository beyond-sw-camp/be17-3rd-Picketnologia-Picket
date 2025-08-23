package com.picketlogia.picket.api.user.model.dto.signup;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SignupResp {

    private List<GenderRead> genders;
    private List<UserTypeRead> userTypes;

    public static SignupResp from() {
        return SignupResp.builder()
                .genders(GenderRead.fromList())
                .userTypes(UserTypeRead.fromList())
                .build();
    }
}
