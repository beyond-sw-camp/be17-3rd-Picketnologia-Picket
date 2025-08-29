package com.picketlogia.picket.api.auth.controller;

import com.picketlogia.picket.api.auth.model.FindEmailDto;
import com.picketlogia.picket.api.auth.model.FindEmailResp;
import com.picketlogia.picket.api.auth.model.ResetPasswordDto;
import com.picketlogia.picket.api.auth.service.UserFindService;
import com.picketlogia.picket.api.auth.service.mail.PasswordResetMailService;
import com.picketlogia.picket.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name ="아이디와 비밀번호 찾기 기능")
public class UserFindController {

    private final UserFindService userFindService;
    private final PasswordResetMailService passwordResetMailService;

    /**
     * 이름과 전화번호로 이메일을 조회
     * @param dto 이메일을 찾기위한 <code>DTO</code>
     */
    @Operation(
            summary = "아이디 찾기",
            description = "전화번호와 이름을 입력하면 아이디를 찾아줍니다."
    )
    @PostMapping("/find-email")
    public ResponseEntity<BaseResponse<Object>> findEmail(@RequestBody FindEmailDto dto) {

        FindEmailResp findUser = userFindService.findEmailByNameAndPhoneNumber(dto);

        return ResponseEntity.ok(BaseResponse.success(findUser));
    }

    /**
     * 비밀번호 재설정 링크를 이메일로 전송
     * @param emailForPwdRest 전송하기 위한 이메일을 받는 <code>DTO</code>
     */
    @Operation(
            summary = "비밀번호 재설정 링크 전송",
            description = "이메일 주소 입력시 비밀번호 재설정 링크 발송"
    )
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
    @Operation(
            summary = "비밀번호 변경",
            description = "이메일로 온 비밀번호 재성정 요청 수행"
    )
    @PostMapping("/reset-password")
    public ResponseEntity<BaseResponse<Object>> resetPassword(@RequestBody ResetPasswordDto dto) {
        userFindService.resetPassword(dto);

        return ResponseEntity.ok(BaseResponse.success("재설정 성공"));
    }
}
