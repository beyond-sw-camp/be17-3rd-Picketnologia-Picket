package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.api.product.model.RoundDateDto;
import com.picketlogia.picket.api.product.model.entity.RoundDate;
import com.picketlogia.picket.api.product.repository.RoundDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundDateService {
    private final RoundDateRepository roundDateRepository;

    // 회차 일정 조회
    public List<RoundDateDto> findAllByProductIdx(Long idx) {
        List<RoundDate> roundDates = roundDateRepository.findAllByProductIdx(idx);
        List<RoundDateDto> roundDateDtos = roundDates.stream().map(entity -> RoundDateDto.from(entity)).collect(Collectors.toList());

        return roundDateDtos;
    }

}
