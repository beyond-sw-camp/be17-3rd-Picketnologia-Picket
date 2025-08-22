package com.picketlogia.picket.api.order.model;

import com.picketlogia.picket.api.orderdetail.model.OrderDetail;
import com.picketlogia.picket.api.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private int price;

    private String payment_idx;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}