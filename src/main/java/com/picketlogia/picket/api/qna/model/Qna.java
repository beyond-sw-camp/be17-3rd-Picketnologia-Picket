package com.picketlogia.picket.api.qna.model;

import com.picketlogia.picket.api.product.model.Product;
import com.picketlogia.picket.api.user.model.entity.User;
import com.picketlogia.picket.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qna extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String contents;

    private String password;

    private Boolean isPrivate;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "product_id")
     private Product product;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "user_id")
     private User user;

    public void update(String title, String contents, Boolean isPrivate) {
        this.title = title;
        this.contents = contents;
        this.isPrivate = isPrivate;
    }
}
