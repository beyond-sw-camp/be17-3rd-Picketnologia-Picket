package com.picketlogia.picket.api.user.model;

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

    private String representativeName;
    private String businessNumber;
    private String businessAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
