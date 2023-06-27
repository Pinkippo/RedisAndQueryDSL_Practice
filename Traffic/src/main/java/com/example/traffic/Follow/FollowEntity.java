package com.example.traffic.Follow;
import com.example.traffic.User.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FollowId.class)
@Table(name = "follow")
public class FollowEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followerId") // 변경된 부분
    private UserEntity follower;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followeeId") // 변경된 부분
    private UserEntity followee;

}
