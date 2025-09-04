package com.picketlogia.picket.api.seat.repository;

import com.picketlogia.picket.common.exception.BaseException;
import com.picketlogia.picket.common.model.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class SeatStatusRepository {

    private final StringRedisTemplate redisTemplate;

    public void updateSeatStatus(String key, String seatId, String status) {
        redisTemplate.opsForHash().put(key, seatId, status);
    }

    public void updateSeatStatusV2(String key, String seatIdx, String status) {
        redisTemplate.opsForHash().put(key, seatIdx, status);
    }

    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public Map<Object, Object> getAllSeatStatus(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public List<Object> getAllSeatStatusV2(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    public void deleteSeatStatus(String key, String seatId) {
        redisTemplate.opsForHash().delete(key, seatId);
    }

    public void allFieldsExist(String key, List<String> seatIdxes) {
        boolean result = seatIdxes.stream().allMatch((seatIdx) -> redisTemplate.opsForHash().hasKey(key, seatIdx));

        if (!result) {
            throw BaseException.from(BaseResponseStatus.NOT_ROCKED_SEAT);
        }
    }

    public void saveSeparateSeat(String key, Long timeout) {
        redisTemplate.opsForValue().set(key, "rocked", timeout, TimeUnit.MILLISECONDS);
    }

    public void deleteSeparateSeat(String key) {
        redisTemplate.delete(key);

    }
}