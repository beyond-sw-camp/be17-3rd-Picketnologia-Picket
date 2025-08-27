package com.picketlogia.picket.api.product.repository;

import com.picketlogia.picket.api.product.model.ProductSearchDto;
import com.picketlogia.picket.api.product.model.entity.Product;
import com.picketlogia.picket.api.product.model.entity.QProduct;
import com.picketlogia.picket.api.review.model.entity.QReview;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductQueryRepository {
    private final JPAQueryFactory queryFactory;
    private final QProduct product;
    private final QReview review;

    public ProductQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.product = QProduct.product;
        this.review = QReview.review;
    }

    public List<Product> search(ProductSearchDto dto) {
        List<Product> result = queryFactory
                .selectFrom(product)
                .where(
                        //이름으로 검색
                        nameContains(dto.getName())
                )
                .fetch();

        return result;
    }

    public List<Product> sortProductRating() {
        List<Product> result = queryFactory
                .selectFrom(product)
                .leftJoin(product.reviewList, review)
                .groupBy(product.idx)
                .orderBy(review.rating.avg().desc())
                .fetch();

        return result;
    }

    public List<Product> sortProductReviewCount() {
        List<Product> result = queryFactory
                .selectFrom(product)
                .leftJoin(product.reviewList, review)
                .groupBy(product.idx)
                .orderBy(review.count().desc())
                .fetch();

        return result;
    }





    private boolean hasText(String str) {
        return str != null && !str.isBlank();
    }

    private BooleanExpression nameContains(String name) {
        return hasText(name) ? product.name.containsIgnoreCase(name) : null;
    }

    private BooleanExpression ratingContains(String rating) {
        return hasText(rating) ? product.rating.containsIgnoreCase(rating) : null;
    }


}
