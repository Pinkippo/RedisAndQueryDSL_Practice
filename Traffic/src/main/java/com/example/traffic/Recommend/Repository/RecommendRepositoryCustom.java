package com.example.traffic.Recommend.Repository;

/**
 *  RecommendRepositoryCustom 인터페이스 -> 커스텀이 필요한 메서드를 정의
 */
public interface RecommendRepositoryCustom {

    boolean CheckRecommend(long uid, long bid);

}
