package com.levelupseon.board.controller;

import com.levelupseon.board.dto.BoardDTO;
import com.levelupseon.board.dto.PageRequestDTO;
import com.levelupseon.board.service.BoardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
  private final BoardService service;

  //목록 조회
  @GetMapping("list")
  public void list(@ModelAttribute("requestDto") PageRequestDTO dto, Model model) {
    model.addAttribute("dto", service.getList(dto));
  }
  //등록폼
  @GetMapping("register")
  public void register() {}

  //등록 프로세스
  @PostMapping("register")
  public String register(BoardDTO dto, RedirectAttributes rttr) {
    //새로 추가된 엔터티 번호
    rttr.addFlashAttribute("msg", service.register(dto));
    return "redirect:/board/list";
  }

}
