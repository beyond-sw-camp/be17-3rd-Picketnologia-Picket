package com.picketlogia.picket.api.orderdetail.model;

import com.picketlogia.picket.api.order.model.Order;
import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.user.model.entity.User;
import com.picketlogia.picket.common.model.SeatGrade;
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
public class OrderDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String seat;

    @Enumerated(EnumType.STRING)
    private SeatGrade seatGrade;

    // 회차 정보?
}
