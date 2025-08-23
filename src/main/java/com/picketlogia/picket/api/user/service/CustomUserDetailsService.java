package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.api.user.model.entity.User;
import com.picketlogia.picket.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> findUser = userRepository.findByEmail(username);
        if (findUser.isPresent()) {
            User user = findUser.get();

            return UserAuth.builder()
                    .idx(user.getIdx())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .nickname(user.getNickname())
                    .role(user.getUserRole().getName())
                    .userType(user.getUserType().name())
                    .build();
        }

        return null;
    }
}
