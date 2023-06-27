package com.example.traffic.Recommend.Repository;

import com.example.traffic.Recommend.RecommendEntity;
import com.example.traffic.Recommend.RecommendId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<RecommendEntity, RecommendId> {
}
