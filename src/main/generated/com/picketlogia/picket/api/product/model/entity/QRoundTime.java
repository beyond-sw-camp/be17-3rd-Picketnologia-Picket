package com.picketlogia.picket.api.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoundTime is a Querydsl query type for RoundTime
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoundTime extends EntityPathBase<RoundTime> {

    private static final long serialVersionUID = -1797054921L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoundTime roundTime = new QRoundTime("roundTime");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QRoundDate roundDate;

    public final TimePath<java.time.LocalTime> times = createTime("times", java.time.LocalTime.class);

    public QRoundTime(String variable) {
        this(RoundTime.class, forVariable(variable), INITS);
    }

    public QRoundTime(Path<? extends RoundTime> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoundTime(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoundTime(PathMetadata metadata, PathInits inits) {
        this(RoundTime.class, metadata, inits);
    }

    public QRoundTime(Class<? extends RoundTime> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roundDate = inits.isInitialized("roundDate") ? new QRoundDate(forProperty("roundDate"), inits.get("roundDate")) : null;
    }

}

