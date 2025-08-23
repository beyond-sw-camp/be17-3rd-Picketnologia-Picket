package com.picketlogia.picket.api.region.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegionRead {
    private String code;
    private String name;

    public static RegionRead of(Region region) {
        return RegionRead.builder()
                .code(region.getCode())
                .name(region.getName())
                .build();
    }
}
