package com.picketlogia.picket.api.sortoption.model;

import lombok.Getter;

@Getter
public enum SortOption {
    NEWEST("최신순"),
    DAILY_RANK("일간 랭킹순"),
    WEEKLY_RANK("주간 랭킹순"),
    MOST_REVIEWS("리뷰 많은순"),
    NEAR_END("종료 임박순");

    private final String name;

    SortOption(String name) {
        this.name = name;
    }

}

