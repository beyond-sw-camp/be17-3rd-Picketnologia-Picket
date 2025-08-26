package com.picketlogia.picket.api.seat.repository;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.seat.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s JOIN FETCH s.seatGrade sg WHERE s.product = :product")
    List<Seat> findAllByProductWithSeatGrade(Product product);
}
