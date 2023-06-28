package com.example.traffic.User;

import com.example.traffic.User.DATA.UserEntity;
import com.example.traffic.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public long UserRegister(String name, String pw){
        UserEntity user = new UserEntity(name,pw);
        return userRepository.save(user).getUid();
    }

}
