package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    public void encode(User entity, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        entity.updatePassword(encodedPassword);
    }

    public void changePassword(User entity, String password) {
        encode(entity, password);
    }
}
