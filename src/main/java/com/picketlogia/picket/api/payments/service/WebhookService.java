package com.picketlogia.picket.api.payments.service;

import com.picketlogia.picket.common.exception.BaseException;
import com.picketlogia.picket.common.model.BaseResponseStatus;
import io.portone.sdk.server.webhook.Webhook;
import io.portone.sdk.server.webhook.WebhookTransaction;
import io.portone.sdk.server.webhook.WebhookVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebhookService {

    @Value("${portone.key.webhook}")
    private String secretKey;

    private final WebhookVerifier portoneWebhook;
    private final PaymentService paymentService;

    public WebhookService(PaymentService paymentService) {
        this.portoneWebhook = new WebhookVerifier(secretKey);
        this.paymentService = paymentService;
    }

    /**
     * 포트원에서 요청한 웹훅을 처리한다.
     * @param body 웹훅 요청 <code>body</code>
     * @param webhookId 웹훅 ID
     * @param webhookTimestamp 웹훅 타임스탬프
     * @param webhookSignature 웹훅 검증을 위한 시그니처
     */
    public void handleWebhook(String body, String webhookId, String webhookTimestamp, String webhookSignature) {

        Webhook webhook;

        try {
            webhook = portoneWebhook.verify(body, webhookId, webhookSignature, webhookTimestamp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw BaseException.from(BaseResponseStatus.FAILED_PAYMENT_WEBHOOK);
        }

        if (webhook instanceof WebhookTransaction transaction) {
            paymentService.completePayment(transaction.getData().getPaymentId());
        }
    }
}
