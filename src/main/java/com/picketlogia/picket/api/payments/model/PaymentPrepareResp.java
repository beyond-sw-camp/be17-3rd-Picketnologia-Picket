package com.picketlogia.picket.api.payments.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentPrepareResp {

    @NotBlank
    private String paymentIdx;
}
