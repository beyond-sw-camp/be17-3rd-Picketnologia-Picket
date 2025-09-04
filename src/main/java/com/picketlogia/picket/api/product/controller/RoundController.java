package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.RoundDateDto;
import com.picketlogia.picket.api.product.service.RoundDateService;
import com.picketlogia.picket.api.seat.service.SeatStatusService;
import com.picketlogia.picket.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {
    private final RoundDateService roundDateService;
    private final SeatStatusService seatStatusService;

    //일정 및 회차 조회
    @GetMapping
    public ResponseEntity<BaseResponse<List<RoundDateDto>>> getAllRound(Long idx) {
        List<RoundDateDto> roundDates = roundDateService.findAllByProductIdx(idx);

        return ResponseEntity.ok(BaseResponse.success(roundDates));
    }

    // 특정 회차의 현재 좌석 상태 전체 조회 (추가)
    @Operation(
            summary = "실시간 좌석 상태 조회",
            description = "회차 ID에 해당하는 모든 좌석의 실시간 상태(예: available, selecting)를 조회합니다."
    )
    @GetMapping("/seat-status/{roundId}/{datetime}")
    public ResponseEntity<BaseResponse<Map<Object, Object>>> getSeatStatus(
            @PathVariable Long roundId,
            @PathVariable String datetime) {
        Map<Object, Object> seatStatus = seatStatusService.getAllSeatStatus(roundId, datetime);
        return ResponseEntity.ok(BaseResponse.success(seatStatus));
    }
}
