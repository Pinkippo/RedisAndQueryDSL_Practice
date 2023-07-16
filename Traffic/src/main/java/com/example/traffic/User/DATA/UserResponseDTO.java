package com.example.traffic.User.DATA;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private long uid;
    private String name;

    public UserResponseDTO(UserEntity user){
        this.uid = user.getUid();
        this.name = user.getName();
    }

}
