package com.picketlogia.picket.api.sortoption.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SortOptionList {
    private List<SortOptionRead> sortOptions;

    public static SortOptionList from(List<SortOption> sortOptions) {
        return SortOptionList.builder()
                .sortOptions(
                        sortOptions.stream().map(SortOptionRead::from).toList()
                )
                .build();
    }
}
