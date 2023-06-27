package com.example.traffic.Follow.DATA;

import com.example.traffic.User.DATA.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowId implements Serializable {
    private UserEntity follower;
    private UserEntity followee;
}
