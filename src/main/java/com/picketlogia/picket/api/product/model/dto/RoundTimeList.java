package com.picketlogia.picket.api.product.model.dto;

import com.picketlogia.picket.api.product.model.entity.RoundTime;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RoundTimeList {
    private List<RoundTimeRead> times;

    public static RoundTimeList from(List<RoundTime> entity) {
        return RoundTimeList.builder().times(entity.stream().map(RoundTimeRead::from).toList()).build();
    }
}
