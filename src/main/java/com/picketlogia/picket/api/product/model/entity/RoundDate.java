package com.picketlogia.picket.api.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
// 일정 정보 DTO
public class RoundDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    // 날짜 & 시간 객체
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // 회차 정보 1:N관계 정립
    @OneToMany(mappedBy = "roundDate")
    private List<RoundTime> roundTimes;

}

