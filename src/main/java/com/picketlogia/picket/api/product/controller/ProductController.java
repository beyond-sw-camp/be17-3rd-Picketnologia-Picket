package com.picketlogia.picket.api.product.controller;

import com.picketlogia.picket.api.product.model.ProductRegister;
import com.picketlogia.picket.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/register")
    //ModelAttribute로 실행했을땐 프론트에서 안받아진 이유
    public ResponseEntity register(@RequestPart ProductRegister product, @RequestPart List<MultipartFile> files) throws SQLException, IOException {
        ProductRegister result = productService.register(product, files);
        return ResponseEntity.ok("등록 완료");

    }
}
