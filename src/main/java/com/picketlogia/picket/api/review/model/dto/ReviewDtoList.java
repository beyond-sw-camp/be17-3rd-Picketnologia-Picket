package com.picketlogia.picket.api.review.model.dto;


import com.picketlogia.picket.api.review.model.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ReviewDtoList {
    private String name;
    private Integer rating;
    private String comment;
    private Date createdAt;
    private Date updatedAt;

    public static ReviewDtoList from(Review entity){
        ReviewDtoList dto = ReviewDtoList.builder()
                .name(entity.getName())
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
        return dto;
    }
}
