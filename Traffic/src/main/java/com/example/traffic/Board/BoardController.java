package com.example.traffic.Board;

import com.example.traffic.Board.DATA.BoardRequestDTO;
import com.example.traffic.Board.DATA.SpecBoardResponseDTO;
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
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글 작성
    @PostMapping("/write")
    public ResponseEntity<DefaultRes<SpecBoardResponseDTO>> WriteBoard(@RequestBody BoardRequestDTO boardRequestDTO){
        SpecBoardResponseDTO spec = boardService.BoardWrite(boardRequestDTO);
        if(spec != null){
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.WRITE_BOARD, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.DB_ERROR,ResponseMessage.NOT_FOUND_USER, null), HttpStatus.OK);
        }

    }

    // 글 조회

    // 글 리스트


}
