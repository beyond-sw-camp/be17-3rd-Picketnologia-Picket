package com.picketlogia.picket.api.seat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class SeatStatusRepository {

    private final StringRedisTemplate redisTemplate;

    public void updateSeatStatus(String key, String seatId, String status) {
        redisTemplate.opsForHash().put(key, seatId, status);
    }

    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public Map<Object, Object> getAllSeatStatus(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}