package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.ProductReadForList;
import com.picketlogia.picket.api.product.service.ProductService;
import com.picketlogia.picket.common.model.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/products")
@RequiredArgsConstructor
@Tag(name = "홈 화면을 위한 상품 기능 관련 컨트롤러")
public class ProductFilterForHomeController {

    private final ProductService productService;

    @Operation(
            summary = "홈 화면에서 보여줄 상품 조회입니다.",
            description = "장르별 5위권 랭킹 공연 목록을 조회합니다. 랭킹의 기준은 판매순입니다."
    )
    @GetMapping("/best-sellers")
    public ResponseEntity<BaseResponse<List<ProductReadForList>>> getBestSellers(@RequestParam String genre) {

        List<ProductReadForList> top10Products = productService.findTop5ByGenreOrderBySalesCount(genre);
        return ResponseEntity.ok(BaseResponse.success(top10Products));

    }
}
