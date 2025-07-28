package com.levelupseon.board.controller;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("replies")
@Log4j2
@Data
public class ReplyController {
  @GetMapping("board/{bno}")
//  @RequestMapping(value = "board/{bno}", method = {RequestMethod.GET, RequestMethod.POST })
  public ResponseEntity<?> getList(@PathVariable("bno") Long bno) {

    log.info(bno);
    return ResponseEntity.ok(bno);
  }
}
