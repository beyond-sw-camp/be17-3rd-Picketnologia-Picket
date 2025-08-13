package com.picketlogia.picket.api.auth.model;

import lombok.Getter;

@Getter
public class AuthCodeMail {
    private String code;
    private String email;
}
