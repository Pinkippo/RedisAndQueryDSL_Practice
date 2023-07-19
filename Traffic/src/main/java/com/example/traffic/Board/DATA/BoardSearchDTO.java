package com.example.traffic.Board.DATA;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardSearchDTO {
    private String title;
    private String content;
    private String name;
}
