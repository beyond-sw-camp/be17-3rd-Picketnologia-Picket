package com.picketlogia.picket.api.genre.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GenreRead {
    private int idx;
    private String code;
    private String name;

    public static GenreRead from(Genre entity) {
        return GenreRead.builder()
                .idx(entity.getIdx())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}
