package com.picketlogia.picket.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeyExpiredListener implements MessageListener {

    private final StringRedisTemplate redisTemplate;

    public KeyExpiredListener(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString(); // 만료된 key 이름
        System.out.println("만료된 키: " + expiredKey);

        // 만약 key가 seat:roundTimeIdx:seatIdx 형식이라면,
        // hash에서도 삭제 처리 가능
        if (expiredKey.startsWith("seat:")) {
            String substring = expiredKey.substring("seat:".length());

            String[] parts = substring.split("-");
            String roundTimeIdx = parts[0];
            String seatIdx = parts[1];

            String key = "seat-status : " + roundTimeIdx;
            redisTemplate.opsForHash().delete(key, seatIdx);
        }
    }
}