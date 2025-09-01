package com.picketlogia.picket.api.seller.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@Tag(name="판매자 권한 확인 기능")
public class SellerController {

    @Operation(
            summary = "판매자 권한 확인",
            description = "유저의 권환을 확인한다."
    )
    @GetMapping("/test")
    public String test() {
        return "seller 권한입니다.";
    }
}
