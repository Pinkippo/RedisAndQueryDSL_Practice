package com.example.traffic.Comment.Repository;

import com.example.traffic.Comment.DATA.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  사용자 정의 Repository -> 커스텀이 필요한 메서드 정의를 CommentRepositoryCustom 인터페이스에 정의하고, CommentRepositoryImpl 구현체 작성
 */
public interface CommentRepository extends JpaRepository<CommentEntity, Long>, CommentRepositoryCustom{

}
