package com.picketlogia.picket.api.contents.controller;

import com.picketlogia.picket.api.contents.model.ContentsResp;
import com.picketlogia.picket.api.contents.service.ContentsService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContentsController {

    private final ContentsService contentsService;

    @GetMapping("/contents/{genre}")
    public ResponseEntity<BaseResponse<ContentsResp>> getContents(@PathVariable String genre) {
        ContentsResp contents = contentsService.findContents(genre);

        return ResponseEntity.ok(BaseResponse.success(contents));
    }
}
