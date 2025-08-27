package com.picketlogia.picket.api.contents.model;

import com.picketlogia.picket.api.product.model.ProductReadForList;
import com.picketlogia.picket.api.product.model.ProductReadForUpcoming;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ContentsResp {

    private Integer currentPage;
    private Integer totalPage;
    private List<ProductReadForList> products;
    private List<ProductReadForUpcoming> upcomingPerformances;

    public static ContentsResp from(List<ProductReadForList> products,
                                    Integer currentPage,
                                    Integer totalPage, List<ProductReadForUpcoming> upcomingPerformances) {

        return ContentsResp.builder()
                .products(products)
                .currentPage(currentPage)
                .totalPage(totalPage)
                .upcomingPerformances(upcomingPerformances)
                .build();

    }
}
