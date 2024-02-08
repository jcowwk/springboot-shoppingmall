package com.example.springbootshoppingmall.controller;

import com.example.springbootshoppingmall.dto.BoardDto;
import com.example.springbootshoppingmall.entity.BoardEntity;
import com.example.springbootshoppingmall.repository.BoardRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) { this.boardRepository = boardRepository; }

    @GetMapping("/boardpage")
    public String BoardPage(Model model) {
        List<BoardEntity> boardEntityList = (List<BoardEntity>)
        boardRepository.findAll();

        model.addAttribute("boardList", boardEntityList);
        return "board/boardpage";
    }

    @GetMapping("/readpage/{board_id}")
    public String ReadPage(@PathVariable int board_id, Model model) {
        BoardEntity boardEntity = boardRepository.findById(board_id).orElse(null);
        model.addAttribute("board", boardEntity);

        return "board/readpage";
    }

    @GetMapping("/writepage")
    public String WritePage() { return "board/writepage"; }

    @PostMapping("/write")
    public String Write(BoardDto boardDto) {
        BoardEntity boardEntity = boardDto.toEntity();
        boardRepository.save(boardEntity);

        return "board/boardpage";
    }

    @GetMapping("/updatepage/{board_id}")
    public String UpdatePage(@PathVariable int board_id, Model model) {
        BoardEntity boardEntity = boardRepository.findById(board_id).orElse(null);
        model.addAttribute("board",boardEntity);
        return "board/updatepage";
    }

    @PostMapping("/update")
    public String Update(BoardDto boardDto) {
        BoardEntity boardEntity = boardDto.toEntity();
        boardRepository.save(boardEntity);

        return "redirect:/board/readpage/" + boardEntity.getBoard_id();
    }

    @GetMapping("/delete/{board_id}")
    public String Delete(@PathVariable int board_id, RedirectAttributes rttr) {
        BoardEntity boardEntity = boardRepository.findById(board_id).orElse(null);

        if (boardEntity != null) {
            boardRepository.delete(boardEntity);
            rttr.addAttribute("msg", boardEntity.getBoard_id() + "번 글이 삭제되었습니다.");
        }

        return "board/boardpage";
    }
}