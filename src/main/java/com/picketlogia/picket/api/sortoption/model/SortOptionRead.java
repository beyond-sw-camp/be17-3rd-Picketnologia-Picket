package com.picketlogia.picket.api.sortoption.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SortOptionRead {
    private String code;
    private String name;

    public static SortOptionRead from(SortOption sortOption) {
        return SortOptionRead.builder().
                code(sortOption.name())
                .name(sortOption.getName()).
                build();
    }
}
