package com.picketlogia.picket.api.review.controller;

import com.picketlogia.picket.api.review.model.dto.ReviewDtoList;
import com.picketlogia.picket.api.review.model.dto.ReviewDtoRegister;
import com.picketlogia.picket.api.review.model.dto.ReviewList;
import com.picketlogia.picket.api.review.service.ReviewService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody  ReviewDtoRegister dto){
     reviewService.save(dto);

     return ResponseEntity.status(200).body("리뷰저장성공");

    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<ReviewDtoList> response = reviewService.list();

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/listPaging")// 페이지 번호는 0번부터
    public ResponseEntity listPaging(Integer page, Integer size) {
        ReviewList response = reviewService.listpaging(page, size);

        return ResponseEntity.status(200).body(BaseResponse.success(response));
    }

}
