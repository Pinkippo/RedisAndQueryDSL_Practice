package com.example.traffic.Recommend;

import com.example.traffic.Recommend.DATA.RecommendEntity;
import com.example.traffic.Recommend.DATA.RecommendId;
import com.example.traffic.Recommend.DATA.RecommendRequestDTO;
import com.example.traffic.Recommend.DATA.RecommendResponseDTO;
import com.example.traffic.Recommend.Repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RecommendService {

    private final RecommendRepository recommendRepository;

    //좋아요 누르기 - + / -
    public RecommendResponseDTO Recommend(RecommendRequestDTO recommendRequestDTO){
        return new RecommendResponseDTO(null);
    }

}
