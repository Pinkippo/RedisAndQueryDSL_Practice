package com.example.traffic.Board.DATA;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardRequestDTO {

    private String name;
    private String title;
    private String content;

}
