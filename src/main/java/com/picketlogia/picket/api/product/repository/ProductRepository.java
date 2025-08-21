package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByIdx(Long idx);
    List<Product> findByGenre(Genre genre);
    List<Product> findTop5ByGenreAndOpenDateAfterOrderByOpenDateAsc(Genre genre, LocalDateTime now);
}
