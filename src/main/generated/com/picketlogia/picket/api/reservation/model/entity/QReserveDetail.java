package com.picketlogia.picket.api.reservation.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReserveDetail is a Querydsl query type for ReserveDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReserveDetail extends EntityPathBase<ReserveDetail> {

    private static final long serialVersionUID = -1467051924L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReserveDetail reserveDetail = new QReserveDetail("reserveDetail");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QReservation reservation;

    public final com.picketlogia.picket.api.product.model.entity.QRoundTime roundTime;

    public final com.picketlogia.picket.api.seat.model.QSeat seat;

    public final EnumPath<com.picketlogia.picket.api.seat.model.SeatGradeStatus> seatGrade = createEnum("seatGrade", com.picketlogia.picket.api.seat.model.SeatGradeStatus.class);

    public QReserveDetail(String variable) {
        this(ReserveDetail.class, forVariable(variable), INITS);
    }

    public QReserveDetail(Path<? extends ReserveDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReserveDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReserveDetail(PathMetadata metadata, PathInits inits) {
        this(ReserveDetail.class, metadata, inits);
    }

    public QReserveDetail(Class<? extends ReserveDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new QReservation(forProperty("reservation"), inits.get("reservation")) : null;
        this.roundTime = inits.isInitialized("roundTime") ? new com.picketlogia.picket.api.product.model.entity.QRoundTime(forProperty("roundTime"), inits.get("roundTime")) : null;
        this.seat = inits.isInitialized("seat") ? new com.picketlogia.picket.api.seat.model.QSeat(forProperty("seat"), inits.get("seat")) : null;
    }

}

