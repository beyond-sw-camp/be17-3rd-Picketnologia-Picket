package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.User;
import com.picketlogia.picket.api.user.model.UserRegister;
import com.picketlogia.picket.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User signup(UserRegister register) {
        return userRepository.save(register.toUserEntity());
    }
}
