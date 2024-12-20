package com.jpaProject.study.comment.service;

import com.jpaProject.study.comment.domain.Comment;
import com.jpaProject.study.comment.dto.CommentDTO;
import com.jpaProject.study.comment.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    private Authentication authentication;

    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }


    public CommentDTO createComment(CommentDTO commentDTO) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        commentDTO.setCommentCreateDate(LocalDateTime.now());
        User principal = (User) authentication.getPrincipal();

        commentDTO.setUserName(principal.getUsername());

        Comment comment = modelMapper.map(commentDTO, Comment.class);

        Comment save = commentRepository.save(comment);

        return modelMapper.map(save, CommentDTO.class);



    }
}
