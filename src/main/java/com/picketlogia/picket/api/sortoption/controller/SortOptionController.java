package com.picketlogia.picket.api.sortoption.controller;

import com.picketlogia.picket.api.sortoption.model.SortOption;
import com.picketlogia.picket.api.sortoption.model.SortOptionList;
import com.picketlogia.picket.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/sort-options")
@Tag(name="정렬 조건 목록 기능")
public class SortOptionController {

    @Operation(
            summary = "정렬 옵션 목록을 반환",
            description = "정렬할 옵션 목록들을 반환한다."
    )
    @GetMapping()
    public ResponseEntity<BaseResponse<SortOptionList>> getSortOptions() {
        return ResponseEntity.ok(
                BaseResponse.success(
                        SortOptionList.from(
                                Arrays.stream(SortOption.values()).toList()
                        )
                )
        );
    }
}
