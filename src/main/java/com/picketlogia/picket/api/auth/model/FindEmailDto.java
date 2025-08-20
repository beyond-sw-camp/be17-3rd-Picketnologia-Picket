package com.picketlogia.picket.api.auth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindEmailDto {
    private String name;
    private String phoneNumber;
}
