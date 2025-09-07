package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByIdx(Long idx);

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.productImage " +
            "WHERE p.genre.code = :code AND p.openDate > :now " +
            "ORDER BY p.openDate ASC LIMIT 5")
    List<Product> findTop5ByGenre_CodeAndOpenDateAfterOrderByOpenDateAsc(String code,LocalDateTime now);

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.productImage WHERE p.genre.code = :code")
    Page<Product> findByGenre_Code(String code, Pageable pageable);

    List<Product> findTop5ByGenre_CodeOrderBySalesCountDesc(String code);
}