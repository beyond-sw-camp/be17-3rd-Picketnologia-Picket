package com.picketlogia.picket.api.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerformanceRound is a Querydsl query type for PerformanceRound
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerformanceRound extends EntityPathBase<PerformanceRound> {

    private static final long serialVersionUID = 2103224066L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerformanceRound performanceRound = new QPerformanceRound("performanceRound");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QProduct product;

    public final DatePath<java.time.LocalDate> roundDate = createDate("roundDate", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> roundTime = createTime("roundTime", java.time.LocalTime.class);

    public QPerformanceRound(String variable) {
        this(PerformanceRound.class, forVariable(variable), INITS);
    }

    public QPerformanceRound(Path<? extends PerformanceRound> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerformanceRound(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerformanceRound(PathMetadata metadata, PathInits inits) {
        this(PerformanceRound.class, metadata, inits);
    }

    public QPerformanceRound(Class<? extends PerformanceRound> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

