package com.picketlogia.picket.api.product.model;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.product.model.entity.Product;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String description;    // 설명
    private String genre;           // 장르
    private LocalDateTime openDate;    // 오픈 예정일
    private PerformanceRoundRegister roundOption;

    // DTO → Entity 변환
    public Product toEntity(Integer genreId) {
        return Product.builder()
                .name(name)
                .rating(rating)
                .venueName(venueName)
                .venueAddress(venueAddress)
                .startDate(startDate)
                .endDate(endDate)
                .runningTime(runningTime)
                .price(price)
                .description(description)
                .openDate(openDate)
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
                .description(product.getDescription())
                .build();
    }
}
