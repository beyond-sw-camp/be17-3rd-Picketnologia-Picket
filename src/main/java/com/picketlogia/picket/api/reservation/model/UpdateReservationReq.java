package com.picketlogia.picket.api.reservation.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UpdateReservationReq {

    private Long price;
    private LocalDateTime paidAt;
    private PaymentStatus paymentStatus;
    private Long productIdx;

    public static UpdateReservationReq from(Long price, LocalDateTime paidAt, Long productIdx, PaymentStatus paymentStatus) {
        return UpdateReservationReq.builder()
                .productIdx(productIdx)
                .price(price)
                .paidAt(paidAt)
                .paymentStatus(paymentStatus)
                .build();
    }
}
