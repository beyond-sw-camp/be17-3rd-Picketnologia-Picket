package com.picketlogia.picket.api.seat.service;

import com.picketlogia.picket.api.seat.repository.SeatStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SeatStatusService {
    private final SeatStatusRepository seatStatusRepository;
    private static final long SEAT_STATUS_TTL_MINUTES = 10;

    // 특정 회차의 좌석 상태 업데이트
    public void updateSeatStatus(Long roundId, String datetime, String seatId, String status) {
        String key = "seat-status : " + roundId+"-"+datetime;
        seatStatusRepository.updateSeatStatus(key, seatId, status);
        // 캐싱 유효시간 지정
        seatStatusRepository.expire(key, SEAT_STATUS_TTL_MINUTES, TimeUnit.MINUTES);
    }

    // 특정 회차의 전체 좌석 상태 조회
    public Map<Object, Object> getAllSeatStatus(Long roundId, String datetime) {
        String key = "seat-status : " + roundId+"-"+datetime;

        return seatStatusRepository.getAllSeatStatus(key);
    }
}
