package com.jpaProject.study.board.controller;

import com.jpaProject.study.board.domain.Board;
import com.jpaProject.study.board.dto.BoardDTO;
import com.jpaProject.study.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardController {

    private final BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @PostMapping("/board")
    public String createBoard(@ModelAttribute BoardDTO boardDTO) {
        BoardDTO resultData = boardService.createBoard(boardDTO);

        System.out.println("등록된 결과는 :" + resultData.toString());

        return "redirect:/";
    }




}
