package com.picketlogia.picket.api.product.model.dto;

import com.picketlogia.picket.api.product.model.entity.RoundTime;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class RoundTimeRead {
    private Long idx;
    private LocalTime time;

    public static RoundTimeRead from(RoundTime entity) {
        return RoundTimeRead.builder()
                .idx(entity.getIdx())
                .time(entity.getTime())
                .build();
    }
}
