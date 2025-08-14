package com.picketlogia.picket.api.user.controller;

import com.picketlogia.picket.api.user.model.GenderResp;
import com.picketlogia.picket.api.user.model.UserRegister;
import com.picketlogia.picket.api.user.model.UserTypeResp;
import com.picketlogia.picket.api.user.service.SignupService;
import com.picketlogia.picket.api.user.service.UserService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
