package com.picketlogia.picket.api.product.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductList {
    List<ProductReadList> productList;

    public static ProductList from(List<Product> products) {
        return ProductList.builder()
                .productList(products.stream().map(ProductReadList::from).toList())
                .build();
    }
}
