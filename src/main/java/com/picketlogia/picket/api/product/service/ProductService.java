package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.product.model.ProductRegister;
import com.picketlogia.picket.api.product.model.ProductImage;
import com.picketlogia.picket.api.product.repository.ProductImageRepository;
import com.picketlogia.picket.api.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final UploadService uploadService;

    public ProductRegister register(ProductRegister dto, List<MultipartFile> files) throws SQLException, IOException {

        // 1. 게시글을 DB에 저장
        Product product = productRepository.save(dto.toEntity());

        // 2. 게시글 이미지 정보를 DB에 저장
        for (MultipartFile file : files) {
            ProductImage productImage = ProductImage.builder()      // 원본 파일명
                    .fileName(file.getOriginalFilename())           // 어떤 상품의 이미지인지 명시
                    .product(product)
                    .build();
            productImageRepository.save(productImage);              // 이미지 메타데이터 DB저장

            // 3. 파일을 서버에 저장
            uploadService.upload(file);                             // 실제 파일 업로드(로컬, S3중에 어디??)
        }
        return ProductRegister.fromEntity(product);
    }
}
