package com.picketlogia.picket.api.reservation.model.entity;

import com.picketlogia.picket.api.product.model.entity.RoundTime;
import com.picketlogia.picket.api.seat.model.SeatGradeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "reservation_idx")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "round_time_idx")
    private RoundTime roundTime;

    @Enumerated(EnumType.STRING)
    private SeatGradeStatus seatGrade;
}
