package com.picketlogia.picket.api.product.model;

import com.picketlogia.picket.api.qna.model.Qna;
import com.picketlogia.picket.api.review.model.entity.Review;
import com.picketlogia.picket.api.user.model.User;
import com.picketlogia.picket.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String name; // 상품이름
    private String category; // 카테고리 (장르)
    private String rating; // 관람등급
    private String venueName; // 공연장명
    private String venueAddress; // 공연장 주소
    private LocalDate startDate; // 공연 시작일
    private LocalDate endDate; // 공연 종료일
    private Integer runningTime; // 러닝타임
    private Integer price; // 가격
    private LocalDate sessionDate; // 회차 날짜
    private Integer sessionTime; // 회차 시간
    private String description; // 설명

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "product")
    private List<Qna> qnaList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "product")
    private ProductImage productImage;
}
