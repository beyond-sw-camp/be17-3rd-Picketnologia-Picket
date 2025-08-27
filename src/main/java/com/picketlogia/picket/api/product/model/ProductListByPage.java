package com.picketlogia.picket.api.product.model;

import com.picketlogia.picket.api.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductListByPage {

    private Integer currentPage;
    private Integer totalPage;
    private List<ProductReadForList> products;

    public static ProductListByPage from(List<Product> products, Integer currentPage, Integer totalPages) {
        return ProductListByPage.builder()
                .products(products.stream().map(ProductReadForList::from).toList())
                .currentPage(currentPage)
                .totalPage(totalPages)
                .build();
    }
}
