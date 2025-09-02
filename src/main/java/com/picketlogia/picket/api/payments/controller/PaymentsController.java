package com.picketlogia.picket.api.payments.controller;

import com.picketlogia.picket.api.payments.service.WebhookService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentsController {

    private final WebhookService webHookService;

    @PostMapping("/payment/webhook")
    public ResponseEntity<BaseResponse<Object>> validPayment(@RequestBody String body,
                                                             @RequestHeader("webhook-id") String webhookId,
                                                             @RequestHeader("webhook-timestamp") String webhookTimestamp,
                                                             @RequestHeader("webhook-signature") String webhookSignature) {

        webHookService.handleWebhook(body, webhookId, webhookTimestamp, webhookSignature);
        return ResponseEntity.ok(BaseResponse.success(null));
    }
}