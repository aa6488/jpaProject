package com.jpaProject.study.board.controller;

import com.jpaProject.study.board.domain.Board;
import com.jpaProject.study.board.dto.BoardDTO;
import com.jpaProject.study.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user,
                           Model model) {

        System.out.println("로그인 성공 유저 정보는 : "+ user.toString());

        List<BoardDTO> boardList = boardService.getBoardAll();



        model.addAttribute("boardList", boardList);

        return "board";
    }


    @PostMapping("/board")
    public String createBoard(@ModelAttribute BoardDTO boardDTO) {
        BoardDTO resultData = boardService.createBoard(boardDTO);

        System.out.println("등록된 결과는 :" + resultData.toString());

        return "redirect:/";
    }

    @DeleteMapping("/board/delete/{boardNo}")
    public ResponseEntity deleteBoard(@PathVariable Long boardNo) {
        System.out.println("삭제할 보드는 : " + boardNo);
        boardService.deleteBoard(boardNo);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/board/detail/{boardNo}")
    public String boardDetail(@PathVariable Long boardNo, Model model) {

        BoardDTO boardDTO = boardService.getBoardOne(boardNo);

        model.addAttribute("board", boardDTO);

        return "boardDetail";
    }



}
