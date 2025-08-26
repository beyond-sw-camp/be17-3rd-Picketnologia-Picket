package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.ProductList;
import com.picketlogia.picket.api.product.model.RoundDateDto;
import com.picketlogia.picket.api.product.model.entity.RoundTime;
import com.picketlogia.picket.api.product.service.RoundDateService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {
    private final RoundDateService roundDateService;

    //일정 및 회차 조회
    @GetMapping
    public ResponseEntity<BaseResponse<List<RoundDateDto>>> getAllRound(Long idx) {
        List<RoundDateDto> roundDates = roundDateService.findAllByProductIdx(idx);

        return ResponseEntity.ok(BaseResponse.success(roundDates));
    }

}
