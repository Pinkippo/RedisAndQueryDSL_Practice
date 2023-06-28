package com.example.traffic.User;

import com.example.traffic.User.DATA.UserRegisterDTO;
import com.example.traffic.User.DATA.UserResponseDTO;
import com.example.traffic.httpReturn.DefaultRes;
import com.example.traffic.httpReturn.ResponseMessage;
import com.example.traffic.httpReturn.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<DefaultRes<UserResponseDTO>> UserRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        long userid = userService.UserRegister(userRegisterDTO.getName(), userRegisterDTO.getPassword());
        if(userid != 0){
            UserResponseDTO userResponseDTO = new UserResponseDTO(userid, userRegisterDTO.getName());
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED_USER, userResponseDTO), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.NOT_CREATED_USER, null), HttpStatus.OK);
        }
    }


}
