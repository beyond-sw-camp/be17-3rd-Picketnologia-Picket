package com.picketlogia.picket.api.orderdetail.service;

import com.picketlogia.picket.api.orderdetail.repository.OrderDetailRepository;
import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public Boolean hasPurchasedProduct(Long userIdx, Long productIdx) {
        Long countByUser = orderDetailRepository.countByUserAndProduct(
                User.builder().idx(userIdx).build(),
                Product.builder().idx(productIdx).build()
        );

        return countByUser > 0;
    }
}
