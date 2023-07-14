package com.example.traffic.Comment;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.Board.Repository.BoardRepository;
import com.example.traffic.Comment.DATA.CommentEntity;
import com.example.traffic.Comment.DATA.CommentRequestDTO;
import com.example.traffic.Comment.DATA.SpecCommentResponseDTO;
import com.example.traffic.Comment.Repository.CommentRepository;
import com.example.traffic.User.DATA.UserEntity;
import com.example.traffic.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    //댓글 작성
    public SpecCommentResponseDTO CommentWirte(CommentRequestDTO commentRequestDTO, UserEntity user){
        Optional<BoardEntity> board = boardRepository.findById(commentRequestDTO.getBid());
        if(board.isEmpty())
            return null;
        CommentEntity comment = new CommentEntity(user, board.get(), commentRequestDTO.getContent());
        commentRepository.save(comment);

        return SpecCommentResponseDTO.builder()
                .cid(comment.getCid())
                .uid(comment.getUser().getUid())
                .name(comment.getUser().getName())
                .writeDate(comment.getWriteDate())
                .content(comment.getContent())
                .build();
    }

    //댓글 삭제

}
