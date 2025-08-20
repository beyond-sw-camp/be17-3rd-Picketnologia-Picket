package com.picketlogia.picket.api.genre.repository;

import com.picketlogia.picket.api.genre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByCode(String code);
}
