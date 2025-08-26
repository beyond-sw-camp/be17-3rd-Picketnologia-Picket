package com.picketlogia.picket.api.seat.model.dto.read;

import com.picketlogia.picket.api.seat.model.Seat;
import com.picketlogia.picket.api.seat.model.SeatGradeStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SeatRead {

    private String name;
    private SeatGradeStatus grade;
    private MoneyFormat priceInfo;

    public static SeatRead from(Seat entity) {
        return SeatRead.builder()
                .name(entity.getName())
                .grade(entity.getSeatGrade().getGrade())
                .priceInfo(
                        MoneyFormat.from(entity.getSeatGrade().getPrice())
                )
                .build();
    }
}
