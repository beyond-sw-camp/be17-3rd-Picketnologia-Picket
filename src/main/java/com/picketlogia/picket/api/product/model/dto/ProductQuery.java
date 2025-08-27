package com.picketlogia.picket.api.product.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQuery {
    private Integer page;
    private String genre;
}
