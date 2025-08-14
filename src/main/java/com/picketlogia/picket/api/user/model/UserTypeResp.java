package com.picketlogia.picket.api.user.model;

import com.picketlogia.picket.api.user.model.enums.UserType;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
public class UserTypeResp {
    private String name;
    private String description;

    public static List<UserTypeResp> from() {
        return Arrays.stream(UserType.values()).map(map -> UserTypeResp.builder()
                        .name(map.name())
                        .description(map.getDescription())
                        .build()
                )
                .toList();
    }
}
