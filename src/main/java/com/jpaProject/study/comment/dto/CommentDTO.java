package com.jpaProject.study.comment.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long commentNo;
    private Long boardNo;
    private String userNo;
    private String userName;
    private String commentDetail;
    private LocalDateTime commentCreateDate;
}
