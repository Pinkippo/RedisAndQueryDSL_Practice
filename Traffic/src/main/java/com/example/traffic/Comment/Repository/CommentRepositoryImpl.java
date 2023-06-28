package com.example.traffic.Comment.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


/**
 *  사용자 정의 Repository 구현체 -> Querydsl 를 사용해 세부 기능이 구현된 메서드를 작성
 */
@RequiredArgsConstructor
@Repository
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    // 하단에 QueryDSL 코드 작성
}
