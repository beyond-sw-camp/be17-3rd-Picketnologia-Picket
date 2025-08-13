package com.picketlogia.picket.api.qna.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class QnaDto {

    @Getter
    @NoArgsConstructor
    public static class CreateRequest {
        private String title;
        private String contents;
        private Boolean isPrivate;
        private String password;

        public Qna toEntity() {
            return Qna.builder()
                    .title(title)
                    .contents(contents)
                    .isPrivate(isPrivate)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequest {
        private String title;
        private String contents;
        private Boolean isPrivate;
        private String password; // 수정 시 비밀번호 확인용
    }

    @Getter
    public static class Response {
        private final Long id;
        private final String title;
        private final String contents;
        private final Boolean isPrivate;
        private final LocalDateTime createdAt;

        public Response(Qna qna) {
            this.id = qna.getIdx();
            this.title = qna.getTitle();
            this.contents = qna.getIsPrivate() ? "비밀글입니다." : qna.getContents();
            this.isPrivate = qna.getIsPrivate();
            this.createdAt = qna.getCreatedAt();
        }
    }
}