package com.picketlogia.picket.api.qna.service;


import com.picketlogia.picket.api.qna.model.QnaPost;
import com.picketlogia.picket.api.qna.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaRepository qnaRepository;

    public void CreatePost(QnaPost qnaPost){


    }

}
