package com.jpaProject.study.board.service;

import com.jpaProject.study.board.domain.Board;
import com.jpaProject.study.board.dto.BoardDTO;
import com.jpaProject.study.board.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private Authentication authentication = null;
    private final ModelMapper modelMapper;



    public BoardService(BoardRepository boardRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
    }


    public BoardDTO createBoard(BoardDTO boardDTO) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        boardDTO.setBoardCreateDate(LocalDateTime.now());
        User principal = (User) authentication.getPrincipal();

        boardDTO.setUserName(principal.getUsername());

        Board board = modelMapper.map(boardDTO, Board.class);

        Board save = boardRepository.save(board);

        return modelMapper.map(save, BoardDTO.class);


    }

    public List<BoardDTO> getBoardAll() {

        List<Board> boardList = boardRepository.findAll();

        List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();

        for (Board board : boardList) {
            boardDTOList.add(modelMapper.map(board, BoardDTO.class));
        }


        return boardDTOList;
    }

    public void deleteBoard(Long boardNo) {
        boardRepository.deleteById(boardNo);
    }

    public BoardDTO getBoardOne(Long boardNo) {
        Board board = boardRepository.findById(boardNo)
                .orElseThrow(() -> new IllegalStateException("해당데이터는 없는값입니다."));

        return modelMapper.map(board, BoardDTO.class);
    }
}
