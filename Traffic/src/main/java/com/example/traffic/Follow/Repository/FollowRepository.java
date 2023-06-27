package com.example.traffic.Follow.Repository;

import com.example.traffic.Follow.FollowEntity;
import com.example.traffic.Follow.FollowId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  사용자 정의 Repository -> 커스텀이 필요한 메서드 정의를 FollowRepositoryCustom 인터페이스에 정의하고, FollowRepositoryImpl 구현체 작성
 */
public interface FollowRepository extends JpaRepository<FollowEntity, FollowId>, FollowRepositoryCustom {

}
