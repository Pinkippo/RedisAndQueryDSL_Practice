package com.example.traffic.Board.DATA;

import com.example.traffic.User.DATA.UserResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SpecBoardResponseDTO {

    private long bid;
    private UserResponseDTO userResponseDTO;
    private Date writeDate;
    private String title;
    private String content;
    private int view;
    private int recommend;

    @Builder
    public SpecBoardResponseDTO(long bid, UserResponseDTO userResponseDTO, Date writeDate, String title, String content, int view, int recommend) {
        this.bid = bid;
        this.userResponseDTO = userResponseDTO;
        this.writeDate = writeDate;
        this.title = title;
        this.content = content;
        this.view = view;
        this.recommend = recommend;
    }
}
