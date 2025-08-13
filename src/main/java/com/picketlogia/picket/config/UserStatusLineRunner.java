package com.picketlogia.picket.config;

import com.picketlogia.picket.api.user.model.UserStatus;
import com.picketlogia.picket.api.user.model.enums.UserStatusEnum;
import com.picketlogia.picket.api.user.repository.UserStatusRepository;
import com.picketlogia.picket.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
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
