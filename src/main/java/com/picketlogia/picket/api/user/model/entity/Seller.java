package com.picketlogia.picket.api.user.model.entity;

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
public class Seller {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String representativeName;

    @Column(nullable = false)
    private String businessNumber;

    @Column(nullable = false)
    private String businessAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
