package com.picketlogia.picket.api.review.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.picketlogia.picket.api.review.model.entity.Review;
import com.picketlogia.picket.utils.CustomDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class ReviewDtoList {
    @Schema(description = "리뷰의 별점", example = "5", minimum = "1", maximum = "5")
    private Integer rating;

    @Schema(description = "리뷰 내용 ", example = "정말 좋은 공연이었습니다.")
    private String comment;

    @JsonFormat(pattern = "MM.dd(E) HH:mm", timezone = "Asia/Seoul")
    private Date createdAt;

    @JsonFormat(pattern = "MM.dd(E) HH:mm", timezone = "Asia/Seoul")
    private Date updatedAt;

    @Schema(description = "상품 이름 ", example = "오페라의 유령")
    private String prodcutName;

    @Schema(description = "닉네임", example = "test01")
    private String userNickName;

    public static ReviewDtoList from(Review entity){

        ReviewDtoList dto = ReviewDtoList.builder()
                .prodcutName(entity.getProduct().getName())
                .rating(entity.getRating())
                .comment(entity.getComment())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userNickName(entity.getUser().getNickname())
                .build();
        return dto;
    }
}
