package com.picketlogia.picket.api.auth.controller;

import com.picketlogia.picket.api.auth.model.AuthCodeMail;
import com.picketlogia.picket.api.auth.model.ResetPasswordDto;
import com.picketlogia.picket.api.auth.service.AuthService;
import com.picketlogia.picket.api.auth.service.mail.AuthCodeMailService;
import com.picketlogia.picket.api.auth.service.mail.PasswordResetMailService;
import com.picketlogia.picket.common.model.BaseResponse;
import com.picketlogia.picket.common.model.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class EmailVerifyController {

    private final AuthCodeMailService authCodeMailService;
    private final AuthService authService;

    /**
     * 이메일로 인증번호 보내기
     * @param email 전송할 이메일
     */
    @GetMapping("/email/verify-code")
    public ResponseEntity<BaseResponse<Object>> sendAuthCode(String email) {
        authCodeMailService.sendToEmail(email);

        return ResponseEntity.ok(BaseResponse.success("인증 번호 전송 성공"));
    }

    /**
     * 인증번호 검증
     * @param authCodeMail 검증하기 위한 이메일과 인증 번호를 담은 <code>DTO</code>
     * @return
     */
    @PostMapping("/email/verify-code")
    public ResponseEntity<BaseResponse<Object>> verifyCode(@RequestBody AuthCodeMail authCodeMail) {

        try {
            authService.verifyAuthCode(authCodeMail);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(BaseResponse.error(BaseResponseStatus.INVALID_AUTH_CODE));
        }
        return ResponseEntity.ok(BaseResponse.success("이메일 인증 성공"));
    }
}
