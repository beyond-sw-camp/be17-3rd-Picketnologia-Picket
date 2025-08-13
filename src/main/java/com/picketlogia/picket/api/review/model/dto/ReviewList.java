package com.picketlogia.picket.api.review.model.dto;


import com.picketlogia.picket.api.review.model.entity.Review;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class ReviewList {
    private List<ReviewDtoList> reviewDtoLists;
    private Integer totalPages;
    private Long totalCount;
    private Integer currentPage;
    private Integer currentSize;

    public static ReviewList from(List<Review> entityList) {
        return ReviewList.builder()
                .reviewDtoLists(entityList.stream().map(ReviewDtoList::from).toList())
                .build();
    }

    public static ReviewList from(Page<Review> pageResult) {
        return ReviewList.builder()
                .totalPages(pageResult.getTotalPages())
                .totalCount(pageResult.getTotalElements())
                .currentPage(pageResult.getPageable().getPageNumber())
                .currentSize(pageResult.getPageable().getPageSize())
                .reviewDtoLists(pageResult.getContent().stream().map(ReviewDtoList::from).toList())
                .build();
    }
}
