package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.ProductList;
import com.picketlogia.picket.api.product.model.dto.register.ProductRegister;
import com.picketlogia.picket.api.product.model.ProductResp;
import com.picketlogia.picket.api.product.service.ProductService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BaseResponse<ProductList>> getAllProducts() {
        ProductList productList = productService.list();

        return ResponseEntity.ok(BaseResponse.success(productList));
    }

    // 상품 상세 조회
    @GetMapping("/{productId}")
    public ResponseEntity<BaseResponse<ProductResp>> getProduct(@PathVariable Long productId) {
        ProductResp findProduct = productService.read(productId);

        return ResponseEntity.ok(BaseResponse.success(findProduct));
    }

}