package com.example.traffic.Recommend;

import com.example.traffic.Board.BoardEntity;
import com.example.traffic.User.UserEntity;
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
