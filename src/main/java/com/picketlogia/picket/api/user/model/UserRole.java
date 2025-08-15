package com.picketlogia.picket.api.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;
}
