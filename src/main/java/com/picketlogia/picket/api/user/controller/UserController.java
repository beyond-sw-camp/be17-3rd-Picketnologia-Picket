package com.picketlogia.picket.api.user.controller;

import com.picketlogia.picket.api.user.model.UserRegister;
import com.picketlogia.picket.api.user.service.UserService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<BaseResponse<Object>> userForm(@RequestBody UserRegister register) {
        userService.signup(register);

        return ResponseEntity.ok(BaseResponse.success("회원 가입 성공"));
    }
}
