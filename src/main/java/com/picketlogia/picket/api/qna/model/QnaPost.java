package com.picketlogia.picket.api.qna.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class QnaPost {

    private String title;
    private String contents;
    private String password;
    private Boolean is_private;




}
