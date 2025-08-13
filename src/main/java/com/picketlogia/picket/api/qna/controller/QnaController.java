package com.picketlogia.picket.api.qna.controller;

import com.picketlogia.picket.api.qna.model.QnaDto;
import com.picketlogia.picket.api.qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/qna")
public class QnaController {

    private final QnaService qnaService;

    // [문의글 작성]
    @PostMapping("/create_post")
    public ResponseEntity<QnaDto.Response> createQna(@RequestBody QnaDto.CreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.createQna(request));
    }

    // [문의글 전체 조회]
    @GetMapping("/get_all_posts")
    public ResponseEntity<List<QnaDto.Response>> getAllQna() {
        return ResponseEntity.ok(qnaService.findAllQna());
    }

    // [문의글 수정]
    @PutMapping("/update_post/{qnaId}")
    public ResponseEntity<QnaDto.Response> updateQna(@PathVariable Long qnaId, @RequestBody QnaDto.UpdateRequest request) {
        return ResponseEntity.ok(qnaService.updateQna(qnaId, request));
    }
}
