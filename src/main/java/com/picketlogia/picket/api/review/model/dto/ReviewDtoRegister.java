package com.picketlogia.picket.api.review.model.dto;

import com.picketlogia.picket.api.review.model.entity.Review;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ReviewDtoRegister {

    private String name;
    private Integer rating;
    private String comment;


    public Review toEntity(){
        Review entity = Review.builder()
                .name(name)
                .rating(rating)
                .comment(comment)
                .build();
        return entity;
    }

}
