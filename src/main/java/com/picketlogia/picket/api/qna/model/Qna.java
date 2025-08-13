package com.picketlogia.picket.api.qna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Qna {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;
    private String title;
    private String contents;
    private String password;
    private Boolean is_private;

}
