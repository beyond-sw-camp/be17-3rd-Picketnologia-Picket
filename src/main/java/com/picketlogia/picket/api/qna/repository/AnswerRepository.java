package com.picketlogia.picket.api.qna.repository;

import com.picketlogia.picket.api.qna.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByIdxAndIsDeletedIsFalse(Long idx);
}