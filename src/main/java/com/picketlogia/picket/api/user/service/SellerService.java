package com.picketlogia.picket.api.user.service;

import com.picketlogia.picket.api.user.model.dto.UserRegister;
import com.picketlogia.picket.api.user.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public void save(UserRegister userRegister, Long userId) {
        sellerRepository.save(userRegister.toSellerEntity(userId));
    }
}
