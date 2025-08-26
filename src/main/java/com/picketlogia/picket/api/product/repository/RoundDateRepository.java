package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.RoundDateDto;
import com.picketlogia.picket.api.product.model.entity.RoundDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoundDateRepository extends JpaRepository<RoundDate, Long> {
    List<RoundDate> findAllByProductIdx(Long idx);


}
