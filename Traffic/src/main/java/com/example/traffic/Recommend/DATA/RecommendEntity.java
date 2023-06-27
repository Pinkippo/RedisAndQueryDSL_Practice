package com.example.traffic.Recommend.DATA;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.User.DATA.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RecommendId.class)
@Table(name = "recommend")
public class RecommendEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private BoardEntity board;

}
