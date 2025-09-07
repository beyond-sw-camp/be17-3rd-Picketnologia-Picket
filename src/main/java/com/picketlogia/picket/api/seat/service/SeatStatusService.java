package com.picketlogia.picket.api.seat.service;

import com.picketlogia.picket.api.seat.model.dto.RockedSeats;
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

    public void deleteRockedSeats(Long roundTimeIdx, RockedSeats rockedSeats) {

        String key = createKey(roundTimeIdx);
        seatStatusRepository.deleteAllRockedSeatsByRoundTime(
                key,
                rockedSeats.getSeatIdxes().stream().map(String::valueOf).toList()
        );

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

    /**
     * 특정 회차의 좌석 상태를 저장하는 <code>redis-hash</code>의 키 생성
     *
     * @param roundTimeIdx 회차 idx
     * @return <code>redis-hash</code>의 키
     */
    private String createKey(Long roundTimeIdx) {
        return "seat-status : " + roundTimeIdx;
    }

    /**
     * key:value 형식의 좌석 레디스 삭제
     * @param roundTimeIdx 삭제 회차 idx
     * @param seatIdx 삭제 좌석 idx
     */
    public void deleteSeparateSeat(Long roundTimeIdx, String seatIdx) {
        String key = "seat:" + roundTimeIdx + "-" + seatIdx;
        seatStatusRepository.deleteSeparateSeat(key);
    }
}
