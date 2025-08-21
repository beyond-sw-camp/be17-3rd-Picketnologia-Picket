package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.api.genre.model.Genre;
import com.picketlogia.picket.api.product.model.*;
import com.picketlogia.picket.api.product.repository.ProductImageRepository;
import com.picketlogia.picket.api.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final UploadService uploadService;

    // 상품 등록
    public ProductRegister register(ProductRegister dto, List<MultipartFile> files) throws SQLException, IOException {

        // 1. 게시글을 DB에 저장
        Product product = productRepository.save(dto.toEntity());

        // 2. 게시글 이미지 정보를 DB에 저장
        for (MultipartFile file : files) {
            // 3. 파일을 서버에 저장
            String fileurl = uploadService.upload(file);    // 실제 파일 업로드(S3)

            ProductImage productImage = ProductImage.builder()  // 원본 파일명
                    .fileName(fileurl)  // 어떤 상품의 이미지인지 명시
                    .product(product)
                    .build();
            productImageRepository.save(productImage);  // 이미지 메타데이터 DB저장


        }
        return ProductRegister.fromEntity(product);
    }

    // 상품 조회
    public ProductList list() {
        List<Product> findProducts = productRepository.findAll();
        return ProductList.from(findProducts);
    }

    // 상품 상세 조회
    public ProductResp read(Long idx) {
        Optional<Product> product = productRepository.findByIdx(idx);

        if(product.isPresent()){
            Product entity = product.get();

            return ProductResp.from(entity);
        }

        return null;
    }

    public List<ProductReadList> findByGenre(Integer  genreIdx) {
        List<Product> findProducts = productRepository.findByGenre(
                Genre.builder().idx(genreIdx).build()
        );

        return findProducts.stream().map(ProductReadList::from).toList();
    }

    /**
     * 장르별 조회 화면에 보여주기위한 오픈 예정일이 제일 빠른 5개의 상품을 조회
     * @param genreIdx 장르 식별자
     * @return <code>List<<code>ProductUpcomingRead</code>></code>
     */
    public List<ProductUpcomingRead> getUpcomingProductsByGenre(Integer genreIdx) {

        List<Product> findProducts = productRepository.findTop5ByGenreAndOpenDateAfterOrderByOpenDateAsc(
                Genre.builder().idx(genreIdx).build(),
                LocalDateTime.now()
        );

        return findProducts.stream().map(ProductUpcomingRead::from).toList();
    }
}
