package com.example.traffic.Board;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.Board.DATA.BoardRequestDTO;
import com.example.traffic.Board.DATA.SpecBoardResponseDTO;
import com.example.traffic.Board.Repository.BoardRepository;
import com.example.traffic.Comment.DATA.CommentEntity;
import com.example.traffic.Comment.DATA.CommentForBoardDTO;
import com.example.traffic.User.DATA.UserEntity;
import com.example.traffic.User.DATA.UserResponseDTO;
import com.example.traffic.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    public SpecBoardResponseDTO ReadOneBoard(long bid){
        Optional<BoardEntity> boardEntity =  boardRepository.findById(bid);
        if(boardEntity.isPresent()){
            BoardEntity board = boardEntity.get();
            List<CommentEntity> commentEntities = board.getComments();

            List<CommentForBoardDTO> commentDtoList = commentEntities.stream().map(
                    comment -> new CommentForBoardDTO(comment.getUser().getName(), comment.getWriteDate(), comment.getContent())
            ).toList();

            return SpecBoardResponseDTO.builder()
                    .bid(board.getBid())
                    .userResponseDTO(new UserResponseDTO(board.getUser()))
                    .writeDate(board.getWriteDate())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .view(board.getView())
                    .recommend(board.getRecommend())
                    .comments(commentDtoList)
                    .build();
        }else{
            return null;
        }


    }
    public SpecBoardResponseDTO ReadOneBoardByDsl(long bid){
        BoardEntity boardEntity =  boardRepository.ReadOneboardByDsl(bid);
        if(boardEntity != null){
            List<CommentEntity> commentEntities = boardEntity.getComments();

            List<CommentForBoardDTO> commentDtoList = commentEntities.stream().map(
                    comment -> new CommentForBoardDTO(comment.getUser().getName(), comment.getWriteDate(), comment.getContent())
            ).toList();

            return SpecBoardResponseDTO.builder()
                    .bid(boardEntity.getBid())
                    .userResponseDTO(new UserResponseDTO(boardEntity.getUser()))
                    .writeDate(boardEntity.getWriteDate())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .view(boardEntity.getView())
                    .recommend(boardEntity.getRecommend())
                    .comments(commentDtoList)
                    .build();
        }else{
            return null;
        }


    }

    public List<SpecBoardResponseDTO> ReadBoard(){
        List<BoardEntity> boardEntities = boardRepository.ReadBoardByDsl();
        List<SpecBoardResponseDTO> result = new ArrayList<>();

        for (BoardEntity board: boardEntities) {
            List<CommentForBoardDTO> comments = board.getComments().stream().map(
                    comment -> new CommentForBoardDTO(comment.getUser().getName(), comment.getWriteDate(), comment.getContent())
            ).toList();

            SpecBoardResponseDTO specBoardResponseDTO = SpecBoardResponseDTO.builder()
                    .bid(board.getBid())
                    .userResponseDTO(new UserResponseDTO(board.getUser()))
                    .writeDate(board.getWriteDate())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .view(board.getView())
                    .recommend(board.getRecommend())
                    .comments(comments)
                    .build();

            result.add(specBoardResponseDTO);

        }

        return result;
    }

}
