package com.picketlogia.picket.api.review.repository;

import com.picketlogia.picket.api.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query("SELECT AVG(r.rating) FROM Review r")
    Double findAverageRating();


    List<Review> findByUserIdx(Long userIdx);

    List<Review> findByUserIdxAndCreatedAtBetween(Long userIdx, LocalDateTime start, LocalDateTime end);
}

