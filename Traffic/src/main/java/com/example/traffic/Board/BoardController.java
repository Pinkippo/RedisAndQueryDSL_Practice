package com.example.traffic.Board;

import com.example.traffic.Board.DATA.BoardRequestDTO;
import com.example.traffic.Board.DATA.BoardSearchDTO;
import com.example.traffic.Board.DATA.SpecBoardResponseDTO;
import com.example.traffic.httpReturn.DefaultRes;
import com.example.traffic.httpReturn.ResponseMessage;
import com.example.traffic.httpReturn.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 게시물_단일_조회_v1 - JPA 이용 (쿼리 3줄 나옴)
    @GetMapping("/read/{bid}")
    public ResponseEntity<DefaultRes<SpecBoardResponseDTO>> ReadOneBoard(@PathVariable long bid){
        SpecBoardResponseDTO spec = boardService.ReadOneBoard(bid);
        if(spec != null){
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.READ_SUCCESS, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.NOT_CREATE_BOARD, null), HttpStatus.OK);
        }
    }

    // 게시물_단일_조회_v2 - QueryDSL 이용 (쿼리 3줄 나옴)
    @GetMapping("/read2/{bid}")
    public ResponseEntity<DefaultRes<SpecBoardResponseDTO>> ReadOneBoardByDsl(@PathVariable long bid){
        SpecBoardResponseDTO spec = boardService.ReadOneBoardByDsl(bid);
        if(spec != null){
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.READ_SUCCESS, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.NOT_CREATE_BOARD, null), HttpStatus.OK);
        }
    }


    // 전체 글 조회
    @GetMapping("/read")
    public ResponseEntity<DefaultRes<List<SpecBoardResponseDTO>>> ReadBoard(){
        List<SpecBoardResponseDTO> spec = boardService.ReadBoard();
        if(spec != null){
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.READ_SUCCESS, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.NOT_CREATE_BOARD, null), HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<DefaultRes<List<SpecBoardResponseDTO>>> SearchBoard(@RequestBody BoardSearchDTO boardSearchDTO){
        List<SpecBoardResponseDTO> spec = boardService.SearchBoard(boardSearchDTO);
        if(spec != null){
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.READ_SUCCESS, spec), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK,ResponseMessage.NOT_CREATE_BOARD, null), HttpStatus.OK);
        }
    }


}
