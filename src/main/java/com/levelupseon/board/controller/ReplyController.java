package com.levelupseon.board.controller;

import com.levelupseon.board.domain.dto.ReplyDTO;
import com.levelupseon.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
  private final ReplyService replyService;

  @GetMapping("board/{bno}")
//  @RequestMapping(value = "board/{bno}", method = {RequestMethod.GET, RequestMethod.POST })
  public ResponseEntity<?> getList(@PathVariable("bno") Long bno) {

    log.info(bno);
    return ResponseEntity.ok(bno);
  }

  @PostMapping("")
  public ResponseEntity<?> createReply(@RequestBody ReplyDTO dto) {
    log.info(dto);
    return ResponseEntity.ok(replyService.register(dto));
  }

}
