package com.example.traffic.Comment;

import com.example.traffic.Comment.DATA.CommentRequestDTO;
import com.example.traffic.Comment.DATA.SpecCommentResponseDTO;
import com.example.traffic.User.DATA.UserEntity;
import com.example.traffic.User.UserService;
import com.example.traffic.httpReturn.DefaultRes;
import com.example.traffic.httpReturn.ResponseMessage;
import com.example.traffic.httpReturn.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;

    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    // 댓글 작성
    @PostMapping("/write")
    public ResponseEntity<DefaultRes<SpecCommentResponseDTO>> WriteComment(@RequestBody CommentRequestDTO commentRequestDTO){
        // 사용자가 없으면 유저 없음
        Optional<UserEntity> user = userService.FindUser(commentRequestDTO.getUid());
        if(user.isEmpty())  return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.NOT_FOUND_USER, null), HttpStatus.OK);
        // 댓글 작성
        SpecCommentResponseDTO spec = commentService.CommentWirte(commentRequestDTO,user.get());
        if(spec != null) {
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.WRITE_COMMENT, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.NOT_CREATE_BOARD, null), HttpStatus.OK);
        }
    }

    // 댓글 삭제


}
