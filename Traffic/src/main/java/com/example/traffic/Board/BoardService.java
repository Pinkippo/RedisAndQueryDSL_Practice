package com.example.traffic.Board;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.Board.DATA.BoardRequestDTO;
import com.example.traffic.Board.DATA.SpecBoardResponseDTO;
import com.example.traffic.Board.Repository.BoardRepository;
import com.example.traffic.User.DATA.UserEntity;
import com.example.traffic.User.DATA.UserResponseDTO;
import com.example.traffic.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public SpecBoardResponseDTO BoardWrite(BoardRequestDTO boardRequestDTO){
        Optional<UserEntity> user = userRepository.findByName(boardRequestDTO.getName());
        if(user.isEmpty())
            return null;
        BoardEntity board = new BoardEntity(user.get(),boardRequestDTO.getTitle(),boardRequestDTO.getContent());
        boardRepository.save(board);

        return SpecBoardResponseDTO.builder()
                .bid(board.getBid())
                .userResponseDTO(new UserResponseDTO(user.get().getUid(), user.get().getName()))
                .writeDate(board.getWriteDate())
                .title(board.getTitle())
                .content(board.getContent())
                .view(board.getView())
                .recommend(board.getRecommend())
                .build();

    }
}
