package com.example.traffic.Board.Repository;

import com.example.traffic.Board.DATA.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  사용자 정의 Repository -> 커스텀이 필요한 메서드 정의를 BoardRepositoryCustom 인터페이스에 정의하고, BoardRepositoryImpl 구현체 작성
 */
public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardRepositoryCustom{

}
