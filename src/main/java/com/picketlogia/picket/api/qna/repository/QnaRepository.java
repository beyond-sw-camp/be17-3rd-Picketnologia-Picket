package com.picketlogia.picket.api.qna.repository;

import com.picketlogia.picket.api.qna.model.Qna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QnaRepository extends JpaRepository<Qna, Long> {

    List<Qna> findAllByIsDeletedIsFalse();

    Optional<Qna> findByIdxAndIsDeletedIsFalse(Long idx);
}
