package com.example.traffic.User;

import com.example.traffic.Board.BoardEntity;
import com.example.traffic.Follow.FollowEntity;
import com.example.traffic.Recommend.RecommendEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(name="pw")
    private String pw;

    @Column(name="name", unique = true)
    private String name;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<BoardEntity> boards;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<RecommendEntity> recommends;

    @OneToMany(mappedBy = "follower", orphanRemoval = true)
    private List<FollowEntity> followers;

    @OneToMany(mappedBy = "followee", orphanRemoval = true)
    private List<FollowEntity> followees;




}