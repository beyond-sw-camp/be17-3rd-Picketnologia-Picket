package com.picketlogia.picket.api.auth.controller;

import com.picketlogia.picket.api.auth.model.FindEmailDto;
import com.picketlogia.picket.api.auth.model.FindEmailResp;
import com.picketlogia.picket.api.auth.model.ResetPasswordDto;
import com.picketlogia.picket.api.auth.service.UserFindService;
import com.picketlogia.picket.api.auth.service.mail.PasswordResetMailService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserFindController {

    private final UserFindService userFindService;
    private final PasswordResetMailService passwordResetMailService;

    /**
     * 이름과 전화번호로 이메일을 조회
     * @param dto 이메일을 찾기위한 <code>DTO</code>
     */
    @PostMapping("/find-email")
    public ResponseEntity<BaseResponse<Object>> findEmail(@RequestBody FindEmailDto dto) {

        FindEmailResp findUser = userFindService.findEmailByNameAndPhoneNumber(dto);

        return ResponseEntity.ok(BaseResponse.success(findUser));
    }

    /**
     * 비밀번호 재설정 링크를 이메일로 전송
     * @param emailForPwdRest 전송하기 위한 이메일을 받는 <code>DTO</code>
     */
    @PostMapping("/find-password/link")
    public ResponseEntity<BaseResponse<Object>> sendAuthCodeForResetPassword(@RequestBody ResetPasswordDto emailForPwdRest) {
        String email = emailForPwdRest.getEmail();
        passwordResetMailService.sendToEmail(email);

        return ResponseEntity.ok(BaseResponse.success("비밀번호 재설정 링크 전송 성공"));
    }

    /**
     * 비밀번호 재설정 요청을 수행한다.
     * @param dto 비밀번호 재설정을 위한 <code>DTO</code>
     */
    @PostMapping("/reset-password")
    public ResponseEntity<BaseResponse<Object>> resetPassword(@RequestBody ResetPasswordDto dto) {
        userFindService.resetPassword(dto);

        return ResponseEntity.ok(BaseResponse.success("재설정 성공"));
    }
}
