package com.picketlogia.picket.api.reservation.controller;

import com.picketlogia.picket.api.payments.model.PaymentPrepareResp;
import com.picketlogia.picket.api.payments.service.PaymentIdGenerator;
import com.picketlogia.picket.api.reservation.model.PaymentStatus;
import com.picketlogia.picket.api.reservation.model.PurchaseCheckResp;
import com.picketlogia.picket.api.reservation.model.ReservationCheck;
import com.picketlogia.picket.api.reservation.model.ReservationRegister;
import com.picketlogia.picket.api.reservation.service.ReservationService;
import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/check")
    public ResponseEntity<BaseResponse<PurchaseCheckResp>> hasPurchased(
            @AuthenticationPrincipal UserAuth loginUser,
            @RequestParam Long productIdx) {

        Long userIdx = loginUser.getIdx();

        Boolean hasPurchased = reservationService.hasPurchasedProduct(userIdx, productIdx);

        PurchaseCheckResp resp = PurchaseCheckResp.builder()
                .hasPurchase(hasPurchased)
                .build();
        return ResponseEntity.ok(BaseResponse.success(resp));
    }

    @PostMapping("/validate-seats")
    public ResponseEntity<BaseResponse<PaymentPrepareResp>> checkReservedSeats(
            @AuthenticationPrincipal UserAuth userAuth,
            @RequestBody ReservationCheck reservationCheck) {

        reservationService.checkReservedSeat(reservationCheck);
        reservationService.checkRockSeats(reservationCheck);

        // 좌석 검증 성공, 결제 ID 생성 후 결제 ID와 유저 ID DB에 저장 후 결제 상태를 PENDING 설정
        String paymentIdx = PaymentIdGenerator.generatePaymentId();
        reservationService.register(
                ReservationRegister.from(
                        userAuth.getIdx(),
                        paymentIdx,
                        PaymentStatus.PENDING)
        );

        return ResponseEntity.ok(BaseResponse.success(
                PaymentPrepareResp.builder().paymentIdx(paymentIdx).build())
        );
    }
}