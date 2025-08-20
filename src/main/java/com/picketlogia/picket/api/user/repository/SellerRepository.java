package com.picketlogia.picket.api.user.repository;

import com.picketlogia.picket.api.user.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
