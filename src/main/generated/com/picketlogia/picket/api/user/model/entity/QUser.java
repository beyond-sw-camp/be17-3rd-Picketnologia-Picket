package com.picketlogia.picket.api.user.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1632956561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.picketlogia.picket.common.model.QBaseEntity _super = new com.picketlogia.picket.common.model.QBaseEntity(this);

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.picketlogia.picket.api.user.model.enums.Gender> gender = createEnum("gender", com.picketlogia.picket.api.user.model.enums.Gender.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.picketlogia.picket.api.product.model.entity.Product, com.picketlogia.picket.api.product.model.entity.QProduct> products = this.<com.picketlogia.picket.api.product.model.entity.Product, com.picketlogia.picket.api.product.model.entity.QProduct>createList("products", com.picketlogia.picket.api.product.model.entity.Product.class, com.picketlogia.picket.api.product.model.entity.QProduct.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final QUserRole userRole;

    public final QUserStatus userStatus;

    public final EnumPath<com.picketlogia.picket.api.user.model.enums.UserType> userType = createEnum("userType", com.picketlogia.picket.api.user.model.enums.UserType.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userRole = inits.isInitialized("userRole") ? new QUserRole(forProperty("userRole")) : null;
        this.userStatus = inits.isInitialized("userStatus") ? new QUserStatus(forProperty("userStatus")) : null;
    }

}

