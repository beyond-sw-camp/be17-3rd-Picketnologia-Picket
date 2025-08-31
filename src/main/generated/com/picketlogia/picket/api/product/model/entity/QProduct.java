package com.picketlogia.picket.api.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 341174443L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.picketlogia.picket.common.model.QBaseEntity _super = new com.picketlogia.picket.common.model.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final com.picketlogia.picket.api.genre.model.QGenre genre;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> openDate = createDateTime("openDate", java.time.LocalDateTime.class);

    public final ListPath<PerformanceRound, QPerformanceRound> performanceRounds = this.<PerformanceRound, QPerformanceRound>createList("performanceRounds", PerformanceRound.class, QPerformanceRound.class, PathInits.DIRECT2);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QProductImage productImage;

    public final ListPath<com.picketlogia.picket.api.qna.model.Qna, com.picketlogia.picket.api.qna.model.QQna> qnaList = this.<com.picketlogia.picket.api.qna.model.Qna, com.picketlogia.picket.api.qna.model.QQna>createList("qnaList", com.picketlogia.picket.api.qna.model.Qna.class, com.picketlogia.picket.api.qna.model.QQna.class, PathInits.DIRECT2);

    public final StringPath rating = createString("rating");

    public final ListPath<com.picketlogia.picket.api.review.model.entity.Review, com.picketlogia.picket.api.review.model.entity.QReview> reviewList = this.<com.picketlogia.picket.api.review.model.entity.Review, com.picketlogia.picket.api.review.model.entity.QReview>createList("reviewList", com.picketlogia.picket.api.review.model.entity.Review.class, com.picketlogia.picket.api.review.model.entity.QReview.class, PathInits.DIRECT2);

    public final ListPath<RoundDate, QRoundDate> roundDate = this.<RoundDate, QRoundDate>createList("roundDate", RoundDate.class, QRoundDate.class, PathInits.DIRECT2);

    public final NumberPath<Integer> runningTime = createNumber("runningTime", Integer.class);

    public final ListPath<com.picketlogia.picket.api.seat.model.Seat, com.picketlogia.picket.api.seat.model.QSeat> seatList = this.<com.picketlogia.picket.api.seat.model.Seat, com.picketlogia.picket.api.seat.model.QSeat>createList("seatList", com.picketlogia.picket.api.seat.model.Seat.class, com.picketlogia.picket.api.seat.model.QSeat.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final com.picketlogia.picket.api.user.model.entity.QUser user;

    public final StringPath venueAddress = createString("venueAddress");

    public final StringPath venueName = createString("venueName");

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.genre = inits.isInitialized("genre") ? new com.picketlogia.picket.api.genre.model.QGenre(forProperty("genre")) : null;
        this.productImage = inits.isInitialized("productImage") ? new QProductImage(forProperty("productImage"), inits.get("productImage")) : null;
        this.user = inits.isInitialized("user") ? new com.picketlogia.picket.api.user.model.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

