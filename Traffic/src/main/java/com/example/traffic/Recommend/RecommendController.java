package com.example.traffic.Recommend;

import com.example.traffic.Recommend.DATA.RecommendRequestDTO;
import com.example.traffic.Recommend.DATA.RecommendResponseDTO;
import com.example.traffic.User.UserService;
import com.example.traffic.httpReturn.DefaultRes;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    private final RecommendService recommendService;
    private final UserService userService;

    public RecommendController(RecommendService recommendService, UserService userService) {
        this.recommendService = recommendService;
        this.userService = userService;
    }

    //좋아요 누르기 - + / -
    public ResponseEntity<DefaultRes<RecommendResponseDTO>> Recommend(@RequestBody RecommendRequestDTO recommendRequestDTO){
        return null;
    }

}
