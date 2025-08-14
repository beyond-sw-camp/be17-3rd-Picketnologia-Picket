package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.product.model.ProductRegister;
import com.picketlogia.picket.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    // 상품 등록
    @PostMapping("/register")
    public ResponseEntity register(@RequestPart ProductRegister product, @RequestPart List<MultipartFile> files) throws SQLException, IOException {
        ProductRegister result = productService.register(product, files);
        return ResponseEntity.ok("등록 완료");
    }

    //상품 조회
    @GetMapping("/list")
    //    public ResponseEntity<List<ProductRegister>> getAllProducts() throws SQLException{}
    public ResponseEntity list() {
        List<Product> result = productService.list();

        return ResponseEntity.ok(result);
    }
    // 상품 상세 조회
    @GetMapping("/read")
    public ResponseEntity read(Integer idx) {
        Optional<Product> result = productService.read(idx);

        return ResponseEntity.ok(result);
    }

}