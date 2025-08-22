package com.picketlogia.picket.api.orderdetail.repository;

import com.picketlogia.picket.api.orderdetail.model.OrderDetail;
import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Long countByUserAndProduct(User user, Product product);
}
