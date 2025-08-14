package com.picketlogia.picket.api.user.model;

import com.picketlogia.picket.api.user.model.enums.Gender;
import com.picketlogia.picket.api.user.model.enums.UserType;
import lombok.Getter;

@Getter
public class UserRegister {

    private String email;
    private String password;
    private String nickname;
    private String name;
    private String birth;
    private String phoneNumber;
    private String representativeName;
    private String businessNumber;
    private String businessAddress;
    private UserType userType;
    private Gender gender;

    public User toUserEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .name(name)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .userStatus(
                        UserStatus.builder()
                                .idx(1)
                                .build()
                )
                .userRole(
                        UserRole.builder()
                                .idx(2)
                                .build()
                )
                .userType(userType)
                .gender(gender)
                .build();
    }

    public Seller toSellerEntity(Long userId) {
        return Seller.builder()
                .businessAddress(businessAddress)
                .businessNumber(businessNumber)
                .representativeName(representativeName)
                .user(
                        User.builder()
                                .idx(userId)
                                .build()
                )
                .build();
    }
}