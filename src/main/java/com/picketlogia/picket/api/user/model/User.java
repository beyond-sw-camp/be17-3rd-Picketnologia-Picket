package com.picketlogia.picket.api.user.model;

import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.user.model.enums.Gender;
import com.picketlogia.picket.api.user.model.enums.UserType;
import com.picketlogia.picket.common.model.BaseEntity;
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
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String email;
    private String password;
    private String nickname;
    private String name;
    private String birth;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // 회원 상태
    @ManyToOne
    @JoinColumn(name = "user_status_id")
    private UserStatus userStatus;

    // 회원 역할
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    public void updatePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
