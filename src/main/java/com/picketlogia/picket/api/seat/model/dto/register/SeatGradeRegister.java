package com.picketlogia.picket.api.seat.model.dto.register;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.seat.model.SeatGrade;
import com.picketlogia.picket.api.seat.model.SeatGradeStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SeatGradeRegister {

    private SeatGradeStatus code;
    private int price;

    public SeatGrade toEntity(Long productIdx) {
        return SeatGrade.builder()
                .grade(code)
                .price(price)
                .product(
                        Product.builder()
                                .idx(productIdx)
                                .build()
                )
                .build();
    }
}
