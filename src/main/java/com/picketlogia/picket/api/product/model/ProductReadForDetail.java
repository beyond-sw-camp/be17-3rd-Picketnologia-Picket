package com.picketlogia.picket.api.product.model;

import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.seat.model.dto.read.SeatGradeRead;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ProductReadForDetail {
    private Long idx;
    private String name; // 상품이름
    private String rating; // 관람등급
    private String venueName; // 공연장명
    private String venueAddress; // 공연장 주소
    private LocalDate startDate; // 공연 시작일
    private LocalDate endDate; // 공연 종료일
    private Integer runningTime; // 러닝타임
    private String posterUrl; // 포스터 이미지 경로 (파일명)
    private String description; // 설명
    private Double reviewRating;
    private Integer reviewCount;
    private List<SeatGradeRead> seatGrades;

    public static ProductReadForDetail from(Product product) {
        return ProductReadForDetail.builder()
                .idx(product.getIdx())
                .name(product.getName())
                .rating(product.getRating())
                .venueName(product.getVenueName())
                .venueAddress(product.getVenueAddress())
                .startDate(product.getStartDate())
                .endDate(product.getEndDate())
                .runningTime(product.getRunningTime())
                .description(product.getDescription())
                .reviewCount(product.getReviewCount())
                .reviewRating(product.getReviewRating())
                .posterUrl(product.getProductImage().getFileName())
                .seatGrades(
                        product.getSeatGrades().stream().map(
                                SeatGradeRead::from
                        ).toList()
                )
                .build();
    }
}
