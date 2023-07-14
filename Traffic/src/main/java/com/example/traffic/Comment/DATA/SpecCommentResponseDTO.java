package com.example.traffic.Comment.DATA;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SpecCommentResponseDTO {

    private long cid;
    private long uid;
    private String name;
    private Date writeDate;
    private String content;

    @Builder
    public SpecCommentResponseDTO(long cid, long uid, String name, Date writeDate, String content) {
        this.cid = cid;
        this.uid = uid;
        this.name = name;
        this.writeDate = writeDate;
        this.content = content;
    }

}
