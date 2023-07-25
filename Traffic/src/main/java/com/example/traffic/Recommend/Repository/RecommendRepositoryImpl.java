package com.example.traffic.Recommend.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.traffic.Recommend.DATA.QRecommendEntity.recommendEntity;

/**
 *  사용자 정의 Repository 구현체 -> Querydsl 를 사용해 세부 기능이 구현된 메서드를 작성
 */
@RequiredArgsConstructor
@Repository
public class RecommendRepositoryImpl implements RecommendRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    // 하단에 QueryDSL 코드 작성

    @Override
    public boolean CheckRecommend(long uid, long bid) {
        return queryFactory.selectFrom(recommendEntity)
                .where(recommendEntity.user.uid.eq(uid).and(recommendEntity.board.bid.eq(bid)))
                .fetchFirst() != null;

    }


}
