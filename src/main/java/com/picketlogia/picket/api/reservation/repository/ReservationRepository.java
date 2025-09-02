package com.picketlogia.picket.api.reservation.repository;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.reservation.model.entity.Reservation;
import com.picketlogia.picket.api.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Long countByUserAndProduct(User user, Product product);
    Optional<Reservation> findByPaymentIdx(String paymentIdx);
}
