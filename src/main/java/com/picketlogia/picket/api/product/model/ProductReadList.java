package com.picketlogia.picket.api.product.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProductReadList {
    private Long idx;
    private String name; // 상품이름
    private String venueName; // 공연장명
    private LocalDate startDate; // 공연 시작일
    private LocalDate endDate; // 공연 종료일
    private String posterUrl; // 포스터 이미지 경로 (파일명)
    private Integer price; // 가격

    public static ProductReadList from(Product product) {
        return ProductReadList.builder()
                .idx(product.getIdx())
                .name(product.getName())
                .venueName(product.getVenueName())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .price(product.getPrice())
                .posterUrl(product.getProductImage().getFileName())
                .build();
    }

}
