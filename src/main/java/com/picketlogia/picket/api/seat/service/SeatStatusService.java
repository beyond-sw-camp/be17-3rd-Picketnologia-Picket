package com.picketlogia.picket.api.seat.service;

import com.picketlogia.picket.api.seat.repository.SeatStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SeatStatusService {
    private final SeatStatusRepository seatStatusRepository;
    private static final long SEAT_STATUS_TTL_MILLISECONDS = 1000 * 60 * 10;

    // 특정 회차의 좌석 상태 업데이트
    public void updateSeatStatus(Long roundId, String datetime, String seatId, String status) {
        String key = "seat-status : " + roundId + "-" + datetime;
        seatStatusRepository.updateSeatStatus(key, seatId, status);
        // 캐싱 유효시간 지정
//        seatStatusRepository.expire(key, SEAT_STATUS_TTL_MINUTES, TimeUnit.MINUTES);
    }

    public void updateSeatStatusV2(Long roundTimeIdx, String seatId, String status) {
        String key = createKey(roundTimeIdx);
        seatStatusRepository.updateSeatStatusV2(key, seatId, status);
//        seatStatusRepository.expire(key, SEAT_STATUS_TTL_MINUTES, TimeUnit.MINUTES);
    }

    // 특정 회차의 전체 좌석 상태 조회
    public Map<Object, Object> getAllSeatStatus(Long roundId, String datetime) {
        String key = "seat-status : " + roundId+"-"+datetime;

        return seatStatusRepository.getAllSeatStatus(key);
    }

    // 특정 회차의 전체 좌석 상태 조회
    public Map<Object, Object> getAllSeatStatusV2(Long roundTimeIdx) {
        String key = createKey(roundTimeIdx);

        return seatStatusRepository.getAllSeatStatus(key);
    }

    public void deleteSeatStatus(Long roundTimeIdx, String seatIdx) {
        String key = createKey(roundTimeIdx);
        seatStatusRepository.deleteSeatStatus(key, seatIdx);

    }

    public void validateRockSeats(Long roundTimeIdx, List<String> seatIdxes) {
        String key = createKey(roundTimeIdx);
        seatStatusRepository.allFieldsExist(key, seatIdxes);
    }

    public void saveSeparateSeat(Long roundTimeIdx, String seatIdx) {
        String key = "seat:" + roundTimeIdx + "-" + seatIdx;
        seatStatusRepository.saveSeparateSeat(key, SEAT_STATUS_TTL_MILLISECONDS);
    }

    private String createKey(Long roundTimeIdx) {
        return "seat-status : " + roundTimeIdx;
    }

    public void deleteSeparateSeat(Long roundTimeIdx, String seatIdx) {
        String key = "seat:" + roundTimeIdx + "-" + seatIdx;
        seatStatusRepository.deleteSeparateSeat(key);
    }
}
