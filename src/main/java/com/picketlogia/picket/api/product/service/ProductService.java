package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.api.genre.model.GenreRead;
import com.picketlogia.picket.api.genre.service.GenreService;
import com.picketlogia.picket.api.product.model.*;
import com.picketlogia.picket.api.product.model.dto.ProductQuery;
import com.picketlogia.picket.api.product.model.dto.register.ProductRegister;
import com.picketlogia.picket.api.product.model.entity.Product;
<<<<<<< Updated upstream
=======
import com.picketlogia.picket.api.product.model.entity.ProductImage;
import com.picketlogia.picket.api.product.repository.ProductImageRepository;
import com.picketlogia.picket.api.product.repository.ProductQueryRepository;
>>>>>>> Stashed changes
import com.picketlogia.picket.api.product.repository.ProductRepository;
import com.picketlogia.picket.api.product.service.validator.BaseProductValidator;
import com.picketlogia.picket.api.seat.service.SeatInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final ProductImageService productImageService;
    private final GenreService genreService;

    private final PerformanceRoundService performanceRoundService;
    private final SeatInfoService seatInfoService;
    private final ProductQueryRepository productQueryRepository;
    private final List<BaseProductValidator> productValidators;

    private static final Integer PAGE_SIZE = 10;

    // 상품 등록
    public ProductRegister register(ProductRegister dto, List<MultipartFile> files) throws SQLException, IOException {

        // 상품 등록에 필요한 Validator 실행
        productValidators.forEach(validator -> validator.validate(dto));

        GenreRead findGenre = genreService.findByCode(dto.getGenre());

        // 상품 DB 저장
        Product product = productRepository.save(dto.toEntity(findGenre.getIdx()));

        // 회차 등록
        performanceRoundService.register(dto.getRoundOption(), product);

        // 좌석 정보 등록
        seatInfoService.save(product.getIdx(), dto.getSeatGrade(), dto.getSeatMap());

        // 이미지 업로드
        productImageService.upload(product, files);

        return ProductRegister.fromEntity(product);
    }

    /**
     * 쿼리를 사용한 상품 목록 조회
     * @param query 쿼리 <code>DTO</code>
     * @return <code>ProductListByPage</code>
     */
    public ProductListByPage findAllByQuery(ProductQuery query) {

        if (query.getPage() != null) {
            PageRequest pageRequest = PageRequest.of(query.getPage(), PAGE_SIZE);
            Page<Product> findProducts = productRepository.findByGenre_Code(query.getGenre(), pageRequest);

            return ProductListByPage.from(
                    findProducts.getContent(), findProducts.getNumber(), findProducts.getTotalPages()
            );
        }

//        List<Product> findProducts = productRepository.findAll();
//        return ProductList.from(findProducts );

        return null;
    }

<<<<<<< Updated upstream
    /**
     * 상품을 상세 조회 한다.
     * @param idx 상품의 IDX
     * @return 상품 상세 <code>DTO</code>
     */
    public ProductReadForDetail findProductDetailById(Long idx) {
=======
    //상품  검색
    public List<ProductResp> search(ProductSearchDto dto) {
        List<Product> result = productQueryRepository.search(dto);

        return result.stream().map(ProductResp::from).toList();
    }

    // 상품 상세 조회
    public ProductResp read(Long idx) {
>>>>>>> Stashed changes
        Optional<Product> product = productRepository.findByIdx(idx);

        if(product.isPresent()){
            Product entity = product.get();

            return ProductReadForDetail.from(entity);
        }

        return null;
    }

    /**
     * 장르별 상품 조회, 페이지는 기본 첫번째 페이지, 10개의 데이터를 가지고 온다.
     * @param code 장르 code
     * @return <code>ProductListByPage</code>
     */
    public ProductListByPage findAllByGenre(String code) {


        Page<Product> findProducts = productRepository.findByGenre_Code(
                code,
                PageRequest.of(0, PAGE_SIZE)
        );

        return ProductListByPage.from(
                findProducts.getContent(),
                findProducts.getNumber(),
                findProducts.getTotalPages()
        );
    }

    /**
     * 장르별로 오픈 예정일이 제일 빠른 5개의 상품을 조회
     * @param code 장르 식별자
     * @return <code>List<<code>ProductUpcomingRead</code>></code>
     */
    public List<ProductReadForUpcoming> findUpcomingProductsByGenreCode(String code) {

        List<Product> findProducts = productRepository.findTop5ByGenre_CodeAndOpenDateAfterOrderByOpenDateAsc(
                code,
                LocalDateTime.now()
        );

        return findProducts.stream().map(ProductReadForUpcoming::from).toList();
    }
}
