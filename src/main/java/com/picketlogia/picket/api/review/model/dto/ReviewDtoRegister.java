package com.picketlogia.picket.api.review.model.dto;

import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.review.model.entity.Review;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ReviewDtoRegister {
    private  String name;

    @NotNull(message="별점을 선택해 주세요")
    private Integer rating;

    @NotBlank(message="리뷰내용을 입력해주세요")
    @Lob
    private String comment;

    private Long productId;

    public Review toEntity(){
        Product product = Product.builder()
                .idx(productId).build();

        Review entity = Review.builder()
                .name(name)
                .rating(rating)
                .comment(comment)
                .product(product)
                .build();
        return entity;
    }

}
