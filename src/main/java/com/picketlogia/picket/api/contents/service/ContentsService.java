package com.picketlogia.picket.api.contents.service;

import com.picketlogia.picket.api.contents.model.ContentsResp;
import com.picketlogia.picket.api.genre.model.GenreRead;
import com.picketlogia.picket.api.genre.service.GenreService;
import com.picketlogia.picket.api.product.model.ProductReadList;
import com.picketlogia.picket.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final ProductService productService;
    private final GenreService genreService;

    public ContentsResp findContents(String genre) {
        GenreRead findGenre = genreService.findByCode(genre);
        List<ProductReadList> findProducts = productService.findByGenre(findGenre.getIdx());

        return ContentsResp.builder()
                .products(findProducts)
                .build();
    }

}
