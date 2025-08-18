package com.picketlogia.picket.api.auth.service;

import com.picketlogia.picket.api.auth.model.FindEmailDto;
import com.picketlogia.picket.api.auth.model.FindEmailResp;
import com.picketlogia.picket.api.auth.model.ResetPasswordDto;
import com.picketlogia.picket.api.user.model.User;
import com.picketlogia.picket.api.user.repository.UserRepository;
import com.picketlogia.picket.api.user.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFindService {

    private final UserRepository userRepository;
    private final AuthService authService;
    private final PasswordService passwordService;

    public FindEmailResp findEmailByNameAndPhoneNumber(FindEmailDto dto) {
        Optional<User> result = userRepository.findByNameAndPhoneNumber(dto.getName(), dto.getPhoneNumber());

        if (result.isPresent()) {
            User findUser = result.get();
            return FindEmailResp.from(findUser);
        }

        return null;
    }

    @Transactional
    public void resetPassword(ResetPasswordDto dto) {
        String newPassword = dto.getPassword();

        String token = dto.getToken();

        ResetPasswordDto findEmailDto = authService.verifyUserPasswordReset(token);

        Optional<User> result = userRepository.findByEmail(findEmailDto.getEmail());

        if (result.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 이메일");
        }

        User findUser = result.get();
        passwordService.changePassword(findUser, newPassword);
    }
}
