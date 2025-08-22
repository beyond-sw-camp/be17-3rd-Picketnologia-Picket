package com.picketlogia.picket.api.orderdetail.controller;

import com.picketlogia.picket.api.orderdetail.model.PurchaseCheckResp;
import com.picketlogia.picket.api.orderdetail.service.OrderDetailService;
import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-detail")
@RequiredArgsConstructor
public class OderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping("/check")
    public ResponseEntity<BaseResponse<PurchaseCheckResp>> hasPurchased(
            @AuthenticationPrincipal UserAuth loginUser,
            @RequestParam Long productIdx) {

        Long userIdx = loginUser.getIdx();

        Boolean hasPurchased = orderDetailService.hasPurchasedProduct(userIdx, productIdx);

        PurchaseCheckResp resp = PurchaseCheckResp.builder()
                .hasPurchase(hasPurchased)
                .build();
        return ResponseEntity.ok(BaseResponse.success(resp));
    }
}
