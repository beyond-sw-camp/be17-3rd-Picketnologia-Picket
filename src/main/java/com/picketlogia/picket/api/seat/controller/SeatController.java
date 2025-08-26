package com.picketlogia.picket.api.seat.controller;

import com.picketlogia.picket.api.seat.model.dto.read.SeatInfo;
import com.picketlogia.picket.api.seat.service.SeatInfoService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat-info")
@RequiredArgsConstructor
public class SeatController {

    private final SeatInfoService seatInfoService;

    @GetMapping
    public ResponseEntity<BaseResponse<SeatInfo>> getSeatInfo(@RequestParam("product") Long productIdx) {

        SeatInfo findSeatInfo = seatInfoService.findSeatInfo(productIdx);
        return ResponseEntity.ok(BaseResponse.success(findSeatInfo));

    }
}
