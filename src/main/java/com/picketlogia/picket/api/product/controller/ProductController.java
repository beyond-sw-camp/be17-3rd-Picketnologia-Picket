package com.picketlogia.picket.api.product.controller;

<<<<<<< Updated upstream
import com.picketlogia.picket.api.product.model.ProductListByPage;
import com.picketlogia.picket.api.product.model.dto.ProductQuery;
=======
import com.picketlogia.picket.api.product.model.ProductList;
import com.picketlogia.picket.api.product.model.ProductSearchDto;
>>>>>>> Stashed changes
import com.picketlogia.picket.api.product.model.dto.register.ProductRegister;
import com.picketlogia.picket.api.product.model.ProductReadForDetail;
import com.picketlogia.picket.api.product.service.ProductService;
import com.picketlogia.picket.api.user.model.dto.UserAuth;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    // 상품 등록
    @PostMapping
    public ResponseEntity<BaseResponse<String>> register(@RequestPart ProductRegister product, @RequestPart List<MultipartFile> files) throws SQLException, IOException {
        ProductRegister result = productService.register(product, files);
        return ResponseEntity.ok(BaseResponse.success("등록 완료"));
    }

    //상품 조회
    @GetMapping
    public ResponseEntity<BaseResponse<ProductListByPage>> getProducts(ProductQuery productQuery) {
        ProductListByPage allByQuery = productService.findAllByQuery(productQuery);

        return ResponseEntity.ok(BaseResponse.success(allByQuery));
    }

    // 상품 상세 조회
    @GetMapping("/{productId}")
    public ResponseEntity<BaseResponse<ProductReadForDetail>> getProduct(@PathVariable Long productId) {
        ProductReadForDetail findProduct = productService.findProductDetailById(productId);

        return ResponseEntity.ok(BaseResponse.success(findProduct));
    }
    //상품 조건 검색
    @GetMapping("/search2")
    public ResponseEntity<List<ProductResp>> search(ProductSearchDto dto) {
        List<ProductResp> response = productService.search(dto);

        return ResponseEntity.ok(response);
    }
}