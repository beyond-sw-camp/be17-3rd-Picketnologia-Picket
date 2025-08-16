package com.picketlogia.picket.api.auth.controller;

import com.picketlogia.picket.api.auth.model.FindEmailDto;
import com.picketlogia.picket.api.auth.model.FindEmailResp;
import com.picketlogia.picket.api.auth.service.UserFindService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserFindController {

    private final UserFindService userFindService;

    @PostMapping("/auth/find-email")
    public ResponseEntity<BaseResponse<Object>> findEmail(@RequestBody FindEmailDto dto) {

        FindEmailResp findUser = userFindService.findEmailByNameAndPhoneNumber(dto);

        return ResponseEntity.ok(BaseResponse.success(findUser));
    }
}
