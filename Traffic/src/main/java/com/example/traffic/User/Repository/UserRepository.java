package com.example.traffic.User.Repository;

import com.example.traffic.User.DATA.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 *  사용자 정의 Repository -> 커스텀이 필요한 메서드 정의를 UserRepositoryCustom 인터페이스에 정의하고, UserRepositoryImpl 구현체 작성
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {

    Optional<UserEntity> findByName(String name);
}
