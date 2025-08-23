package com.picketlogia.picket.api.region.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RegionList {

    private List<RegionRead> regions;

    public static RegionList of(List<Region> regions) {
        return RegionList.builder()
                .regions(
                        regions.stream().map(RegionRead::of).toList()
                )
                .build();
    }
}
