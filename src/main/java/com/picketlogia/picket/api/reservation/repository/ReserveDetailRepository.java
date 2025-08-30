package com.picketlogia.picket.api.reservation.repository;

import com.picketlogia.picket.api.reservation.model.entity.ReserveDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveDetailRepository extends JpaRepository<ReserveDetail, Long> {
}
