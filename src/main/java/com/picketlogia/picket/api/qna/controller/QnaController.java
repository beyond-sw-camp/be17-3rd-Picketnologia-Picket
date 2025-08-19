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
    @PostMapping
    public ResponseEntity<QnaDto.Response> createQna(@RequestBody QnaDto.CreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.createQna(request));
    }

    // [문의글 전체 조회]
    @GetMapping
    public ResponseEntity<List<QnaDto.Response>> getAllQna() {
        return ResponseEntity.ok(qnaService.findAllQna());
    }

    // [문의글 단건 조회]
    @GetMapping("/{qnaIdx}")
    public ResponseEntity<QnaDto.Response> getQnaByIdx(@PathVariable Long qnaIdx) {
        return ResponseEntity.ok(qnaService.findQnaByIdx(qnaIdx));
    }

    // [문의글 수정]
    @PutMapping("/{qnaIdx}")
    public ResponseEntity<QnaDto.Response> updateQna(@PathVariable Long qnaIdx, @RequestBody QnaDto.UpdateRequest request) {
        return ResponseEntity.ok(qnaService.updateQna(qnaIdx, request));
    }

    // [문의글 삭제]
    @DeleteMapping("/{qnaIdx}")
    public ResponseEntity<Void> deleteQna(@PathVariable Long qnaIdx) {
        qnaService.deleteQna(qnaIdx);
        return ResponseEntity.noContent().build();
    }

    // [문의글 답변 등록]
    @PostMapping("/{qnaIdx}/answers")
    public ResponseEntity<QnaDto.AnswerResponse> createAnswer(
            @PathVariable Long qnaIdx,
            @RequestBody QnaDto.CreateAnswerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(qnaService.createAnswer(qnaIdx, request));
    }

    // [문의글 답변 수정]
    @PutMapping("/{qnaIdx}/answers/{answerIdx}")
    public ResponseEntity<QnaDto.AnswerResponse> updateAnswer(
            @PathVariable Long qnaIdx,
            @PathVariable Long answerIdx,
            @RequestBody QnaDto.UpdateAnswerRequest request) {
        return ResponseEntity.ok(qnaService.updateAnswer(qnaIdx, answerIdx, request));
    }

    // [문의글 답변 삭제]
    @DeleteMapping("/{qnaIdx}/answers/{answerIdx}")
    public ResponseEntity<Void> deleteAnswer(
            @PathVariable Long qnaIdx,
            @PathVariable Long answerIdx) {
        qnaService.deleteAnswer(qnaIdx, answerIdx);
        return ResponseEntity.noContent().build();
    }

}
