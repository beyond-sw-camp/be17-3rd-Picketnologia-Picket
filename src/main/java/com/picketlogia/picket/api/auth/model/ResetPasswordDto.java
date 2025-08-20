package com.picketlogia.picket.api.auth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResetPasswordDto {
    private String token;
    private String email;
    private String password;
}
