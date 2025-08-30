package com.picketlogia.picket.api.reservation.service;

import com.picketlogia.picket.api.reservation.repository.ReserveDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReserveDetailService {

    private final ReserveDetailRepository reserveDetailRepository;

}
