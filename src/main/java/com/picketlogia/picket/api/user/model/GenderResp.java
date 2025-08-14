package com.picketlogia.picket.api.user.model;

import com.picketlogia.picket.api.user.model.enums.Gender;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
public class GenderResp {
    private String name;
    private String description;

    public static List<GenderResp> from() {
        return Arrays.stream(Gender.values()).map(map -> GenderResp.builder()
                .name(map.name())
                .description(map.getDescription())
                .build())
                .toList();
    }
}
