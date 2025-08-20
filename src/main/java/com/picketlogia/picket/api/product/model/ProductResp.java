package com.picketlogia.picket.api.product.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProductResp {
    private Long idx;
    private String name; // 상품이름
    private String rating; // 관람등급
    private String venueName; // 공연장명
    private String venueAddress; // 공연장 주소
    private LocalDate startDate; // 공연 시작일
    private LocalDate endDate; // 공연 종료일
    private Integer runningTime; // 러닝타임
    private String posterUrl; // 포스터 이미지 경로 (파일명)
    private Integer price; // 가격
    private LocalDate sessionDate; // 회차 날짜
    private Integer sessionTime; // 회차 시간
    private String description; // 설명

    public static ProductResp from(Product product) {
        return ProductResp.builder()
                .idx(product.getIdx())
                .name(product.getName())
                .rating(product.getRating())
                .venueName(product.getVenueName())
                .venueAddress(product.getVenueAddress())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .runningTime(product.getRunningTime())
                .price(product.getPrice())
                .sessionDate(product.getSessionDate())
                .sessionTime(product.getSessionTime())
                .description(product.getDescription())
                .posterUrl(product.getProductImage().getFileName())
                .build();
    }
}
