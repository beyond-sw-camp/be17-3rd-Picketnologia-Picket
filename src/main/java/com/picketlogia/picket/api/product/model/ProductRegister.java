package com.picketlogia.picket.api.product.model;

import com.picketlogia.picket.api.genre.model.Genre;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegister {

    private String name;           // 상품이름
    private String rating;         // 관람등급
    private String venueName;      // 공연장명
    private String venueAddress;   // 공연장 주소
    private LocalDate startDate;   // 공연 시작일
    private LocalDate endDate;     // 공연 종료일
    private Integer runningTime;   // 러닝타임
    private Integer price;         // 가격
    private LocalDate sessionDate; // 회차 날짜
    private Integer sessionTime;   // 회차 시간
    private String description;    // 설명
    private int genreId;           // 장르

    // DTO → Entity 변환
    public Product toEntity() {
        return Product.builder()
                .name(name)
                .rating(rating)
                .venueName(venueName)
                .venueAddress(venueAddress)
                .startDate(startDate)
                .endDate(endDate)
                .runningTime(runningTime)
                .price(price)
                .sessionDate(sessionDate)
                .sessionTime(sessionTime)
                .description(description)
                .genre(
                        Genre.builder().
                                idx(genreId)
                                .build()
                )
                .build();
    }

    public static ProductRegister fromEntity(Product product) {
        return ProductRegister.builder()
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
                .build();
    }
}
