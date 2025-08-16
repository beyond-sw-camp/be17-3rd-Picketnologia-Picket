package com.picketlogia.picket.api.auth.model;

import com.picketlogia.picket.api.user.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindEmailDto {
    private String name;
    private String phoneNumber;
}
