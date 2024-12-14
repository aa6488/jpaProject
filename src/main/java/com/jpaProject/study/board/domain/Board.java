package com.jpaProject.study.board.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "board_detail")
    private String boardDetail;

    @Column(name = "board_create_date")
    private LocalDateTime boardCreateDate;

    @Column(name = "board_delete_date")
    private LocalDateTime boardDeleteDate;

    @Column(name = "board_login_date")
    private LocalDateTime boardLoginDate;
}
