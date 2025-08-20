package com.picketlogia.picket.config;

import com.picketlogia.picket.api.user.model.entity.UserStatus;
import com.picketlogia.picket.api.user.model.enums.UserStatusEnum;
import com.picketlogia.picket.api.user.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

//@Component
@RequiredArgsConstructor
public class UserStatusLineRunner implements CommandLineRunner {

    private final UserStatusRepository userStatusRepository;

    @Override
    public void run(String... args) throws Exception {

        UserStatusEnum[] values = UserStatusEnum.values();

        for (UserStatusEnum value : values) {
            if (!userStatusRepository.existsById(value.getIdx())) {
                userStatusRepository.save(
                        UserStatus.builder()
                                .idx(value.getIdx())
                                .name(value.getValue())
                                .build()
                );
            }
        }
    }
}
