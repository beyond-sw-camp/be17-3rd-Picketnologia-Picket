package com.picketlogia.picket.api.contents.model;

import com.picketlogia.picket.api.product.model.ProductReadList;
import com.picketlogia.picket.api.product.model.ProductUpcomingRead;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ContentsResp {

    private List<ProductReadList> products;
    private List<ProductUpcomingRead> upcomingPerformances;
}
