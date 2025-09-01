package com.picketlogia.picket.api.qna.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQna is a Querydsl query type for Qna
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQna extends EntityPathBase<Qna> {

    private static final long serialVersionUID = 1456170610L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQna qna = new QQna("qna");

    public final com.picketlogia.picket.common.model.QBaseEntity _super = new com.picketlogia.picket.common.model.QBaseEntity(this);

    public final ListPath<Answer, QAnswer> answers = this.<Answer, QAnswer>createList("answers", Answer.class, QAnswer.class, PathInits.DIRECT2);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final BooleanPath isPrivate = createBoolean("isPrivate");

    public final StringPath password = createString("password");

    public final com.picketlogia.picket.api.product.model.entity.QProduct product;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final com.picketlogia.picket.api.user.model.entity.QUser user;

    public QQna(String variable) {
        this(Qna.class, forVariable(variable), INITS);
    }

    public QQna(Path<? extends Qna> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQna(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQna(PathMetadata metadata, PathInits inits) {
        this(Qna.class, metadata, inits);
    }

    public QQna(Class<? extends Qna> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.picketlogia.picket.api.product.model.entity.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.picketlogia.picket.api.user.model.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

