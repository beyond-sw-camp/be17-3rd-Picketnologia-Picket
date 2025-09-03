package com.picketlogia.picket.api.review.repository;

import com.picketlogia.picket.api.review.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query("SELECT AVG(r.rating) FROM Review r")
    Double findAverageRating();

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.product.idx= :productId")
    Double findAverageRatingByProductId(Long productId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.product.idx = :productId")
    long countByProductId(Long productId);

    List<Review> findByUserIdx(Long userIdx);

    List<Review> findByUserIdxAndCreatedAtBetween(Long userIdx, LocalDateTime start, LocalDateTime end);


    Page<Review> findByProductIdx(Long productId,PageRequest of);

    @Query("SELECT r FROM Review r JOIN FETCH r.user u JOIN FETCH r.product p")
    List<Review> findAllWithUserAndProduct();
}

