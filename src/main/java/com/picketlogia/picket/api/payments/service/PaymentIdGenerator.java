package com.picketlogia.picket.api.payments.service;

import java.util.UUID;

public class PaymentIdGenerator {

    public static String generatePaymentId() {
        return UUID.randomUUID().toString();
    }
}
