package com.picketlogia.picket.config;

import com.picketlogia.picket.api.user.model.UserRole;
import com.picketlogia.picket.api.user.model.UserStatus;
import com.picketlogia.picket.api.user.model.enums.UserRoleEnum;
import com.picketlogia.picket.api.user.model.enums.UserStatusEnum;
import com.picketlogia.picket.api.user.repository.UserRoleRepository;
import com.picketlogia.picket.api.user.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRoleLineRunner implements CommandLineRunner {

    private final UserRoleRepository userRoleRepository;

    @Override
    public void run(String... args) throws Exception {

        UserRoleEnum[] values = UserRoleEnum.values();

        for (UserRoleEnum value : values) {
            if (!userRoleRepository.existsById(value.getIdx())) {
                userRoleRepository.save(
                        UserRole.builder()
                                .idx(value.getIdx())
                                .name(value.getName())
                                .build()
                );
            }
        }
    }
}
