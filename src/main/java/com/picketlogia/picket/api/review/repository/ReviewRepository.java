package com.picketlogia.picket.api.review.repository;

import com.picketlogia.picket.api.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query("SELECT AVG(r.rating) FROM Review r")
    Double findAverageRating();

}
