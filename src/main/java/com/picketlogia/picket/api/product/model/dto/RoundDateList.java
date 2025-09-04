package com.picketlogia.picket.api.product.model.dto;

import com.picketlogia.picket.api.product.model.entity.RoundDate;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RoundDateList {
    private List<RoundDateRead> dates;

    public static RoundDateList from(List<RoundDate> entities) {
        return RoundDateList.builder().dates(entities.stream().map(RoundDateRead::from).toList()).build();
    }
}
