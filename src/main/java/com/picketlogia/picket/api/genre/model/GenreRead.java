package com.picketlogia.picket.api.genre.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GenreRead {
    private String code;
    private String name;

    public static GenreRead from(Genre entity) {
        return GenreRead.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}
