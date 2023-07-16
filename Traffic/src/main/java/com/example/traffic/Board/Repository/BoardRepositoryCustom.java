package com.example.traffic.Board.Repository;

import com.example.traffic.Board.DATA.BoardEntity;

import java.util.List;

/**
 *  BoardRepositoryCustom 인터페이스 -> 커스텀이 필요한 메서드를 정의
 */
public interface BoardRepositoryCustom {

    BoardEntity ReadOneboardByDsl(long bid);
}
