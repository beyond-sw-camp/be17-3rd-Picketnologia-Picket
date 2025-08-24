package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
