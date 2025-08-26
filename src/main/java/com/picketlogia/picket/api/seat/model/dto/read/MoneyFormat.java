package com.picketlogia.picket.api.seat.model.dto.read;

import lombok.Builder;
import lombok.Getter;

import java.text.DecimalFormat;

@Getter
@Builder
public class MoneyFormat {

    private Integer price;
    private String priceFormat;

    public static MoneyFormat from(Integer price) {
        return MoneyFormat.builder()
                .price(price)
                .priceFormat(formatToMoney(price))
                .build();
    }

    private static String formatToMoney(Integer price) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(price) + "원";
    }
}
