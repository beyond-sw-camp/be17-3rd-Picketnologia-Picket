package com.picketlogia.picket.api.contents.service;

import com.picketlogia.picket.api.contents.model.ContentsResp;
import com.picketlogia.picket.api.genre.model.GenreRead;
import com.picketlogia.picket.api.genre.service.GenreService;
import com.picketlogia.picket.api.product.model.ProductReadForUpcoming;
import com.picketlogia.picket.api.product.model.ProductListByPage;
import com.picketlogia.picket.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final ProductService productService;

    public ContentsResp findContents(String genre) {

        ProductListByPage findProducts = productService.findAllByGenre(genre);

        List<ProductReadForUpcoming> upcomingProducts =
                productService.findUpcomingProductsByGenreCode(genre);

        return ContentsResp.from(
                findProducts.getProducts(),
                findProducts.getCurrentPage(),
                findProducts.getTotalPage(),
                upcomingProducts
        );
    }

}
