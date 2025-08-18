package com.picketlogia.picket.api.genre.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GenreList {
    List<GenreRead> genres;

    public static GenreList from(List<Genre> genres) {
        return GenreList.builder()
                .genres(genres.stream().map(GenreRead::from).toList())
                .build();
    }
}
