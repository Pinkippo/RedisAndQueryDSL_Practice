package com.example.traffic.Comment.DATA;

import com.example.traffic.Board.DATA.BoardEntity;
import com.example.traffic.User.DATA.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private BoardEntity board;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date writeDate;

    @Column(name="content", length = 100)
    private String content;

    public CommentEntity(UserEntity user, BoardEntity board, String content) {
        this.user = user;
        this.board = board;
        this.content = content;
    }
}
