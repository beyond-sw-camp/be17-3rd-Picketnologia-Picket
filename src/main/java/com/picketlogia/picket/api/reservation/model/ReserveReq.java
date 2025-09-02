package com.picketlogia.picket.api.reservation.model;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.reservation.model.entity.Reservation;
import com.picketlogia.picket.api.user.model.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReserveReq {
    private Long price;
    private String paymentsIdx;
    private Long userIdx;
    private Long productIdx;
    private List<Long> seatIdxList;

    public static ReserveReq from(Long userIdx, Long productIdx, List<Long> seatIdxList) {
        return ReserveReq.builder()
                .userIdx(userIdx)
                .productIdx(productIdx)
                .seatIdxList(seatIdxList)
                .build();
    }

    public Reservation toReserveEntity() {

        return Reservation.builder()
                .price(this.price)
                .paymentIdx(this.paymentsIdx)
                .user(
                        User.builder().idx(this.userIdx).build()
                )
                .product(
                        Product.builder().idx(this.productIdx).build()
                )
                .build();
    }
}
