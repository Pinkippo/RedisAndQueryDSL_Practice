package com.example.traffic.Board.Repository;

import com.example.traffic.Board.DATA.BoardEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


// 해당 클래스의 정적(static) 멤버들을 직접 참조하여 가독성 증가

import java.util.List;

import static com.example.traffic.Board.DATA.QBoardEntity.boardEntity;
import static com.example.traffic.Comment.DATA.QCommentEntity.commentEntity;
import static com.example.traffic.User.DATA.QUserEntity.userEntity;

/**
 *  사용자 정의 Repository 구현체 -> Querydsl 를 사용해 세부 기능이 구현된 메서드를 작성
 */
@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    // 하단에 QueryDSL 코드 작성

    //게시물_단일_조회_v2 0716 한승완
    @Override
    public BoardEntity ReadOneboardByDsl(long bid){
        return queryFactory.selectFrom(boardEntity)
                .where(boardEntity.bid.eq(bid))
                .join(boardEntity.comments, commentEntity).fetchJoin()
                .fetchOne();
    }

    @Override
    public List<BoardEntity> ReadBoardByDsl() {
        return queryFactory.selectFrom(boardEntity)
                .join(boardEntity.comments, commentEntity).fetchJoin()
                .fetch();
    }

}
