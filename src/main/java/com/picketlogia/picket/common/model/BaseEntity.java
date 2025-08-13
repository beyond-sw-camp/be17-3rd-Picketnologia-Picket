package com.picketlogia.picket.common.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // 부모클래스의 변수가 JPA로 동작할 수 있게 해주는 어노테이션
public class BaseEntity {

    @CreatedDate        // 특정 이벤트가 발생했을 때 동작하는 어노테이션 //1 번
    private Date createdAt;
    @LastModifiedDate   //1 번
    private Date updatedAt;

    @PrePersist         //2 번
    void createdAt() {
        this.createdAt = Timestamp.from(Instant.now());
        this.updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate          //2 번
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }
}
