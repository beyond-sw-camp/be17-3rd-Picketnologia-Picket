package com.picketlogia.picket.api.contents.model;

import com.picketlogia.picket.api.product.model.ProductReadList;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ContentsResp {

    private List<ProductReadList> products;
}
