package com.example.traffic.Recommend.DATA;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.User.DATA.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendId implements Serializable {
    private UserEntity user;
    private BoardEntity board;

}
