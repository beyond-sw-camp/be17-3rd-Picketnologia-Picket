package com.picketlogia.picket.api.auth.controller;

import com.picketlogia.picket.api.auth.model.AuthCodeMail;
import com.picketlogia.picket.api.auth.service.AuthCodeMailService;
import com.picketlogia.picket.api.auth.service.AuthService;
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

    @GetMapping("/email/verify-code")
    public ResponseEntity<BaseResponse<Object>> sendAuthCode(String email) {
        authCodeMailService.sendToEmail(email);

        return ResponseEntity.ok(BaseResponse.success("인증 번호 전송 성공"));
    }

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
