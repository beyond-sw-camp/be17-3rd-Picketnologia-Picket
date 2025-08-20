package com.picketlogia.picket.api.auth.service.mail;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MailSend {
    AUTH_CODE_MAIL("[Picket] 안녕하세요. 요청하신 인증번호를 보내드립니다.", "AUTH_CODE_MAIL:"),
    PASSWORD_RESET_MAIL("[Picket] 안녕하세요. 요청하신 비밀번호 재설정 링크를 보내드립니다.", "PASSWORD_RESET_MAIL:");

    private final String subject;
    private final String keyName;

    public String createRedisKey(String param) {
        return keyName.concat(param);
    }
}
