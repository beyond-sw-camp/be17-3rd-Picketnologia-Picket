package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.UserRegister;
import com.picketlogia.picket.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signup(UserRegister register) {
        userRepository.save(register.toEntity());
    }
}
