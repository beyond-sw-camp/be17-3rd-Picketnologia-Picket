package com.picketlogia.picket.api.genre.service;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.genre.model.GenreList;
import com.picketlogia.picket.api.genre.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    // 전체 조회
    public GenreList findAll() {
        List<Genre> result = genreRepository.findAll();

        return GenreList.from(result);
    }
}
