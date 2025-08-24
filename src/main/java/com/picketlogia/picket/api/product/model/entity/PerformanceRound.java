package com.picketlogia.picket.api.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "round_date", nullable = false)
    private LocalDate roundDate;

    @Column(name = "round_time", nullable = false)
    private LocalTime roundTime;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;
}
