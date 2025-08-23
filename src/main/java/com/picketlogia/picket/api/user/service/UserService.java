package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.dto.signup.UserRegister;
import com.picketlogia.picket.api.user.model.entity.User;
import com.picketlogia.picket.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public User signup(UserRegister register) {
        User userEntity = register.toUserEntity();

        passwordService.encode(userEntity, register.getPassword());

        return userRepository.save(userEntity);
    }
}
