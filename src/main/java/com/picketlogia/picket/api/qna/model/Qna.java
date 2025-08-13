package com.picketlogia.picket.api.qna.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String contents;

    private String password;

    private Boolean isPrivate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "product_id")
    // private Product product;

    public void update(String title, String contents, Boolean isPrivate) {
        this.title = title;
        this.contents = contents;
        this.isPrivate = isPrivate;
    }
}
