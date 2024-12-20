package com.jpaProject.study.comment.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo;

    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "comment_detail")
    private String commentDetail;


    @Column(name = "comment_create_date")
    private LocalDateTime commentCreateDate;

}
