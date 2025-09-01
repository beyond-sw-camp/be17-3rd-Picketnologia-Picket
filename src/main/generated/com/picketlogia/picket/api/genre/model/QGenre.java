package com.picketlogia.picket.api.genre.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGenre is a Querydsl query type for Genre
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGenre extends EntityPathBase<Genre> {

    private static final long serialVersionUID = 1258246256L;

    public static final QGenre genre = new QGenre("genre");

    public final StringPath code = createString("code");

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<com.picketlogia.picket.api.product.model.entity.Product, com.picketlogia.picket.api.product.model.entity.QProduct> products = this.<com.picketlogia.picket.api.product.model.entity.Product, com.picketlogia.picket.api.product.model.entity.QProduct>createList("products", com.picketlogia.picket.api.product.model.entity.Product.class, com.picketlogia.picket.api.product.model.entity.QProduct.class, PathInits.DIRECT2);

    public QGenre(String variable) {
        super(Genre.class, forVariable(variable));
    }

    public QGenre(Path<? extends Genre> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGenre(PathMetadata metadata) {
        super(Genre.class, metadata);
    }

}

