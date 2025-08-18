package com.picketlogia.picket.api.user.controller;

import com.picketlogia.picket.api.user.model.GenderResp;
import com.picketlogia.picket.api.user.model.UserRegister;
import com.picketlogia.picket.api.user.model.UserTypeResp;
import com.picketlogia.picket.api.user.service.SignupService;
import com.picketlogia.picket.api.user.service.UserService;
import com.picketlogia.picket.common.model.BaseResponse;
import com.picketlogia.picket.utils.JwtUtil;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;

    @PostMapping("/user/signup")
    public ResponseEntity<BaseResponse<Object>> userForm(@RequestBody UserRegister register) {
        signupService.signup(register);

        return ResponseEntity.ok(BaseResponse.success("회원 가입 성공"));
    }

    @GetMapping("/user/signup")
    public ResponseEntity<BaseResponse<Object>> signup() {

        Map<String, Object> map = new HashMap<>();

        map.put("userTypes", UserTypeResp.from());
        map.put("genders", GenderResp.from());

        return ResponseEntity.ok(BaseResponse.success(map));
    }

    @PostMapping("/logout")
    public ResponseEntity<BaseResponse<Object>> logout() {

        ResponseCookie responseCookie = ResponseCookie.from(JwtUtil.TOKEN_NAME, null)
                .httpOnly(true)
                .maxAge(0)
                .path("/")
                .build();

        return ResponseEntity.ok()
                .header("Set-Cookie", responseCookie.toString())
                .body(BaseResponse.success(null));
    }
}
