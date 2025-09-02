package com.picketlogia.picket.api.review.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -855549717L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.picketlogia.picket.common.model.QBaseEntity _super = new com.picketlogia.picket.common.model.QBaseEntity(this);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final NumberPath<Integer> idx = createNumber("idx", Integer.class);

    public final com.picketlogia.picket.api.product.model.entity.QProduct product;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final com.picketlogia.picket.api.user.model.entity.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.picketlogia.picket.api.product.model.entity.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.picketlogia.picket.api.user.model.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

