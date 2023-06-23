package com.example.traffic.prac_one;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPracEntity is a Querydsl query type for PracEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPracEntity extends EntityPathBase<PracEntity> {

    private static final long serialVersionUID = 602072424L;

    public static final QPracEntity pracEntity = new QPracEntity("pracEntity");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPracEntity(String variable) {
        super(PracEntity.class, forVariable(variable));
    }

    public QPracEntity(Path<? extends PracEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPracEntity(PathMetadata metadata) {
        super(PracEntity.class, metadata);
    }

}

