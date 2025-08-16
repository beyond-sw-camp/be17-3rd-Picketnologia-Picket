package com.picketlogia.picket.api.auth.service;

import com.picketlogia.picket.api.auth.model.FindEmailDto;
import com.picketlogia.picket.api.auth.model.FindEmailResp;
import com.picketlogia.picket.api.user.model.User;
import com.picketlogia.picket.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFindService {

    private final UserRepository userRepository;

    public FindEmailResp findEmailByNameAndPhoneNumber(FindEmailDto dto) {
        Optional<User> result = userRepository.findByNameAndPhoneNumber(dto.getName(), dto.getPhoneNumber());

        if (result.isPresent()) {
            User findUser = result.get();
            return FindEmailResp.from(findUser);
        }

        return null;
    }
}
