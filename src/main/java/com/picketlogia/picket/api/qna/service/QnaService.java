package com.picketlogia.picket.api.qna.service;


import com.picketlogia.picket.api.qna.model.QnaDto;
import com.picketlogia.picket.api.qna.model.Qna;
import com.picketlogia.picket.api.qna.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaRepository qnaRepository;

    @Transactional
    public QnaDto.Response createQna(QnaDto.CreateRequest request) {
        Qna newQna = request.toEntity();
        Qna savedQna = qnaRepository.save(newQna);
        return new QnaDto.Response(savedQna);
    }

    @Transactional(readOnly = true)
    public List<QnaDto.Response> findAllQna() {
        return qnaRepository.findAll().stream()
                .map(QnaDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public QnaDto.Response updateQna(Long qnaId, QnaDto.UpdateRequest request) {
        Qna qna = qnaRepository.findById(qnaId)
                .orElseThrow(() -> new IllegalArgumentException("해당 문의글을 찾을 수 없습니다. id=" + qnaId));

        if (!Objects.equals(qna.getPassword(), request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        qna.update(request.getTitle(), request.getContents(), request.getIsPrivate());
        return new QnaDto.Response(qna);
    }
}
