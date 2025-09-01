package com.picketlogia.picket.api.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoundDate is a Querydsl query type for RoundDate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoundDate extends EntityPathBase<RoundDate> {

    private static final long serialVersionUID = -1797539048L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoundDate roundDate = new QRoundDate("roundDate");

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QProduct product;

    public final ListPath<RoundTime, QRoundTime> roundTimes = this.<RoundTime, QRoundTime>createList("roundTimes", RoundTime.class, QRoundTime.class, PathInits.DIRECT2);

    public QRoundDate(String variable) {
        this(RoundDate.class, forVariable(variable), INITS);
    }

    public QRoundDate(Path<? extends RoundDate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoundDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoundDate(PathMetadata metadata, PathInits inits) {
        this(RoundDate.class, metadata, inits);
    }

    public QRoundDate(Class<? extends RoundDate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

