package com.picketlogia.picket.api.seat.repository;

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

}