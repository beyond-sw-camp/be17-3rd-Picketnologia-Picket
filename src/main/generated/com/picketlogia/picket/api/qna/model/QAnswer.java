package com.picketlogia.picket.api.qna.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswer is a Querydsl query type for Answer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnswer extends EntityPathBase<Answer> {

    private static final long serialVersionUID = 1151540336L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswer answer = new QAnswer("answer");

    public final com.picketlogia.picket.common.model.QBaseEntity _super = new com.picketlogia.picket.common.model.QBaseEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final QQna qna;

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QAnswer(String variable) {
        this(Answer.class, forVariable(variable), INITS);
    }

    public QAnswer(Path<? extends Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswer(PathMetadata metadata, PathInits inits) {
        this(Answer.class, metadata, inits);
    }

    public QAnswer(Class<? extends Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.qna = inits.isInitialized("qna") ? new QQna(forProperty("qna"), inits.get("qna")) : null;
    }

}

