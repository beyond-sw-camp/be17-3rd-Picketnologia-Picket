package com.picketlogia.picket.api.qna.repository;

import com.picketlogia.picket.api.qna.model.Qna;
import com.picketlogia.picket.api.review.model.entity.Review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QnaRepository extends JpaRepository<Qna, Long> {

    List<Qna> findAllByIsDeletedIsFalse();

    Optional<Qna> findByIdxAndIsDeletedIsFalse(Long idx);

    List<Qna> findByUserIdxAndCreatedAtBetween(Long userIdx, LocalDateTime start, LocalDateTime end);


    Page<Qna> findByProductIdx(Long productId, PageRequest of);

}
