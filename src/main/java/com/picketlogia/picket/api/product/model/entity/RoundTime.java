package com.picketlogia.picket.api.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 회차 정보 DTO
public class RoundTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private LocalTime times;

    @ManyToOne
    @JoinColumn(name = "round_date_idx")
    private RoundDate roundDate;
}
