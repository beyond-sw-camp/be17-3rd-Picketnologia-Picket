package com.picketlogia.picket.api.genre.service;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.genre.model.GenreList;
import com.picketlogia.picket.api.genre.model.GenreRead;
import com.picketlogia.picket.api.genre.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    // 전체 조회
    public GenreList findAll() {
        List<Genre> result = genreRepository.findAll();

        return GenreList.from(result);
    }

    // code로 조회
    public GenreRead findByCode(String code) {
        Optional<Genre> result = genreRepository.findByCode(code);

        Genre findGenre = result.orElseThrow(NoSuchElementException::new);
        return GenreRead.from(findGenre);
    }
}
