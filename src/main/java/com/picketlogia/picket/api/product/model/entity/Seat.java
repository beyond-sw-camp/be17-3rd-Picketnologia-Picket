package com.picketlogia.picket.api.product.model.entity;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.qna.model.Qna;
import com.picketlogia.picket.api.review.model.entity.Review;
import com.picketlogia.picket.api.user.model.entity.User;
import com.picketlogia.picket.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String num; // 좌석 번호

    @ManyToOne
    @JoinColumn(name = "seatRank_id")
    private SeatRank seatRank;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
