package com.picketlogia.picket.api.review.controller;

import com.picketlogia.picket.api.review.model.dto.ReviewDtoList;
import com.picketlogia.picket.api.review.model.dto.ReviewDtoRegister;
import com.picketlogia.picket.api.review.model.dto.ReviewList;
import com.picketlogia.picket.api.review.service.ReviewService;
import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Tag(name = "게시판 기능")
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(
            summary = "리뷰등록",
            description = "상품의 리뷰를 작성하고 등록한다."
    )
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ReviewDtoRegister dto, @AuthenticationPrincipal UserAuth userAuth) {
        reviewService.save(dto, userAuth.getIdx());

        return ResponseEntity.status(200).body("리뷰저장성공");

    }

    @Operation(
            summary = "리뷰전체조회",
            description = "리뷰테이블 전체를 조회한다."
    )

    @GetMapping("/list")
    public ResponseEntity list() {
        List<ReviewDtoList> response = reviewService.list();

        return ResponseEntity.status(200).body(response);
    }

    @Operation(
            summary = "리뷰 목록 조회 - 페이징 기능으로",
            description = "리뷰 목록 조회할 때 page, size를 입력해서 한 페이지 당 특정 수만큼 게시글 조회"
    )
    @GetMapping("/listPaging")// 페이지 번호는 0번부터
    public ResponseEntity listPaging(Integer page, Integer size) {
        ReviewList response = reviewService.listpaging(page, size);

        return ResponseEntity.status(200).body(BaseResponse.success(response));
    }

}
