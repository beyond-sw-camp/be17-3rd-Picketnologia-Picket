package com.picketlogia.picket.api.reservation.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -1281997877L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath paymentIdx = createString("paymentIdx");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final com.picketlogia.picket.api.product.model.entity.QProduct product;

    public final ListPath<ReserveDetail, QReserveDetail> reserveDetails = this.<ReserveDetail, QReserveDetail>createList("reserveDetails", ReserveDetail.class, QReserveDetail.class, PathInits.DIRECT2);

    public final com.picketlogia.picket.api.user.model.entity.QUser user;

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.picketlogia.picket.api.product.model.entity.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.picketlogia.picket.api.user.model.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

