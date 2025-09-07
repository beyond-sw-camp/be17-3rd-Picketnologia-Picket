package com.picketlogia.picket.api.sortoption.model;

import lombok.Getter;

@Getter
public enum SortOption {
    NEWEST("최신순"),
    REVIEW_COUNT("리뷰 많은 순"),
    REVIEW_RATING("평점 높은 순");

    private final String name;

    SortOption(String name) {
        this.name = name;
    }

}

