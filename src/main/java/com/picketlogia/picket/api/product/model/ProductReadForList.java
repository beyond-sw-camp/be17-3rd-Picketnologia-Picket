package com.picketlogia.picket.api.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProductReadForList {
    private Long idx;
    private String name; // 상품이름
    private String venueName; // 공연장명

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate; // 공연 시작일

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate endDate; // 공연 종료일
    private String posterUrl; // 포스터 이미지 경로 (파일명)
    private Double reviewRating;
    private Integer reviewCount;

    public static ProductReadForList from(Product product) {
        return ProductReadForList.builder()
                .idx(product.getIdx())
                .name(product.getName())
                .venueName(product.getVenueName())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .reviewCount(product.getReviewCount())
                .reviewRating(product.getReviewRating())
                .posterUrl(
                        product.getProductImage().getFileName()
                )
                .build();
    }

}
