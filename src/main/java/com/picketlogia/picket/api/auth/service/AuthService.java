package com.picketlogia.picket.api.auth.service;

import com.picketlogia.picket.api.auth.model.AuthCodeMail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 인증 번호를 검증한다.
     * @param authCodeMail 이메일과 인증 코드가 담긴 dto
     * @throws IllegalArgumentException 유효하지 않은 인증 번호인 경우 예외 발생
     */
    public void verifyAuthCode(AuthCodeMail authCodeMail) {

        String findAuthCode = stringRedisTemplate.opsForValue().get(authCodeMail.getEmail());

        if (findAuthCode == null || !findAuthCode.equals(authCodeMail.getCode())) {
            throw new IllegalArgumentException("유효하지 않는 인증 번호");
        }
    }
}
