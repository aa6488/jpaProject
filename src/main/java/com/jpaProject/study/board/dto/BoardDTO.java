package com.jpaProject.study.board.dto;

import com.jpaProject.study.comment.domain.Comment;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDTO {

    private Long boardNo;
    private String userNo;
    private String userName;
    private String boardTitle;
    private String boardDetail;
    private LocalDateTime boardCreateDate;
    private LocalDateTime boardDeleteDate;
    private LocalDateTime boardLoginDate;

    private List<Comment> comments;
}
