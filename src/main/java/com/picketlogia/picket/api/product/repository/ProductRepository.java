package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByIdx(Long idx);
    List<Product> findTop5ByGenre_CodeAndOpenDateAfterOrderByOpenDateAsc(String code, LocalDateTime now);
    Page<Product> findByGenre_Code(String code, Pageable pageable);
}
