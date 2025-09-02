package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.product.model.entity.RoundDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoundDateRepository extends JpaRepository<RoundDate, Long> {
    List<RoundDate> findAllByProductIdx(Long idx);

    List<RoundDate> findALlByProductAndDateAfter(Product product, LocalDate date);
}
