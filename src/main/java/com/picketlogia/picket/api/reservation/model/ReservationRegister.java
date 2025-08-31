package com.picketlogia.picket.api.reservation.model;

import com.picketlogia.picket.api.payments.model.PaymentCustomData;
import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.reservation.model.entity.Reservation;
import com.picketlogia.picket.api.user.model.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReservationRegister {
    private String paymentIdx;
    private Long userIdx;
    private Long productIdx;
    private Long price;
    private LocalDateTime paidAt;
    private PaymentStatus paymentStatus;

    public static ReservationRegister from(Long userIdx,
                                           String paymentIdx,
                                           Long price,
                                           LocalDateTime paidAt,
                                           PaymentCustomData paymentData) {

        return ReservationRegister.builder()
                .paymentIdx(paymentIdx)
                .price(price)
                .userIdx(userIdx)
                .paidAt(paidAt)
                .productIdx(paymentData.getProductIdx())
                .build();

    }

    public static ReservationRegister from(Long userIdx, String paymentIdx, PaymentStatus paymentStatus)  {

        return ReservationRegister.builder()
                .userIdx(userIdx)
                .paymentIdx(paymentIdx)
                .paymentStatus(paymentStatus)
                .price(null)
                .productIdx(null)
                .paidAt(null)
                .build();
    }

    public Reservation toEntity() {
        return Reservation.builder()
                .paymentIdx(this.paymentIdx)
                .paidAt(this.paidAt)
                .user(
                        User.builder().idx(this.userIdx).build()
                )
                .product(
                        this.productIdx != null ? Product.builder().idx(this.productIdx).build() : null
                )
                .price(this.price)
                .paymentStatus(this.paymentStatus)
                .build();
    }

}