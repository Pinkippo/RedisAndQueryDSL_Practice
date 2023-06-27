package com.example.traffic.Board;

import com.example.traffic.Comment.CommentEntity;
import com.example.traffic.Recommend.RecommendEntity;
import com.example.traffic.User.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    @Temporal(TemporalType.DATE)
    private Date writeDate;

    @Column(name="content", length = 254)
    private String content;

    @Column(name = "view", columnDefinition = "int default 0")
    private int view;

    @Column(name="recommend",columnDefinition = "int default 0")
    private int recommend;

    @JsonIgnore
    @BatchSize(size = 500)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecommendEntity> recommends;

    @JsonIgnore
    @BatchSize(size = 500)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;


}
