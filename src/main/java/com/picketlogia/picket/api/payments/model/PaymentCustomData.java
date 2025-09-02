package com.picketlogia.picket.api.payments.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
public class PaymentCustomData {
    private Long productIdx;
    private Long roundTimeIdx;
    private List<Long> seatIdxes;

    public static PaymentCustomData from(String customData) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(customData, PaymentCustomData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
