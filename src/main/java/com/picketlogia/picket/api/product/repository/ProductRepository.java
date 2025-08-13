package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
