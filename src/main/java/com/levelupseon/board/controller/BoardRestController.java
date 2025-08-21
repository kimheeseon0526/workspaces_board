package com.levelupseon.board.controller;

import com.levelupseon.board.domain.dto.BoardDTO;
import com.levelupseon.board.domain.dto.PageRequestDTO;
import com.levelupseon.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("boardrest")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class BoardRestController {
  private final BoardService service;

  //목록 조회
//  @GetMapping("list")
//  public void list(@ModelAttribute("requestDto") PageRequestDTO dto, Model model) {
//    model.addAttribute("dto", service.getList(dto));
//  }

  @GetMapping("list")
  public ResponseEntity<?> getAllBoards(@ModelAttribute("requestDto") PageRequestDTO dto) {
    return ResponseEntity.ok(service.getList(dto));
  }

  //등록 프로세스
  @PostMapping("register")
  public ResponseEntity<?> register(@RequestBody BoardDTO dto) {
    return ResponseEntity.ok(service.register(dto));
  }

  @GetMapping("read")
  public ResponseEntity<?> read(@ModelAttribute("requestDto") PageRequestDTO dto, Long bno) {
    return ResponseEntity.ok(service.get(bno));
  }

  @PostMapping("modify")
  public ResponseEntity<?> modify (@RequestBody BoardDTO boardDTO){
//    rttr.addAttribute("bno", boardDTO.getBno());
//    rttr.addAttribute("page", dto.getPage());
//    rttr.addAttribute("size", dto.getSize());
//    rttr.addAttribute("type", dto.getType());
//    rttr.addAttribute("keyword", dto.getKeyword());
    service.modify(boardDTO);
    return ResponseEntity.ok(boardDTO.getBno());
  }

  @PostMapping("remove")
  public ResponseEntity<?> remove(@RequestBody Long bno) {
    service.remove(bno);

//    rttr.addFlashAttribute("msg", bno);
//    rttr.addAttribute("page", dto.getPage());
//    rttr.addAttribute("size", dto.getSize());
    return ResponseEntity.ok(bno + "번글 삭제 완료");
  }

}
