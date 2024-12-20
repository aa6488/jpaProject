package com.jpaProject.study.comment.controller;

import com.jpaProject.study.comment.dto.CommentDTO;
import com.jpaProject.study.comment.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/comment")
    public String createComment(@ModelAttribute CommentDTO commentDTO) {
        System.out.println("보드넘버는 : " + commentDTO.getBoardNo());
        CommentDTO comment = commentService.createComment(commentDTO);
        System.out.println("저장된 댓글은 : " + comment.toString());

        return "redirect:/board/detail/" + commentDTO.getBoardNo();



    }
}
