package com.example.traffic.Comment.DATA;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CommentForBoardDTO {
    private String name;
    private Date writeDate;
    private String content;

}
