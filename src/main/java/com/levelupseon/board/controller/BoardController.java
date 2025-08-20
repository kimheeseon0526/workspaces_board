package com.levelupseon.board.controller;

import com.levelupseon.board.domain.dto.BoardDTO;
import com.levelupseon.board.domain.dto.PageRequestDTO;
import com.levelupseon.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//  @GetMapping
//  public ResponseEntity<?> getAllBoards(PageRequestDTO dto) {
//    return ResponseEntity.ok(service.getList(dto));
//  }


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

  @GetMapping("read")
  public void read(@ModelAttribute("requestDto") PageRequestDTO dto, Long bno, Model model) {
    model.addAttribute("dto", service.get(bno));

  }

  @GetMapping("modify")
  public void modify (@ModelAttribute("requestDto") PageRequestDTO dto, Long bno, Model model){
    model.addAttribute("dto", service.get(bno));
  }

  @PostMapping("modify")
  public String modify (@ModelAttribute("requestDto") PageRequestDTO dto, BoardDTO boardDTO, RedirectAttributes rttr){
    service.modify(boardDTO);
    rttr.addAttribute("bno", boardDTO.getBno());
    rttr.addAttribute("page", dto.getPage());
    rttr.addAttribute("size", dto.getSize());
    rttr.addAttribute("type", dto.getType());
    rttr.addAttribute("keyword", dto.getKeyword());
    return "redirect:/board/read";
  }

  @PostMapping("remove")
  public String remove(PageRequestDTO dto, Model model, Long bno, RedirectAttributes rttr) {
    service.remove(bno);

    rttr.addFlashAttribute("msg", bno);
    rttr.addAttribute("page", dto.getPage());
    rttr.addAttribute("size", dto.getSize());
    return "redirect:/board/list";
  }

}
