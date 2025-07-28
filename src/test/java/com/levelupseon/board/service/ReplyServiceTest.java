package com.levelupseon.board.service;

import com.levelupseon.board.domain.dto.BoardDTO;
import com.levelupseon.board.domain.dto.ReplyDTO;
import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyServiceTest {
  @Autowired
  private ReplyService replyService;

  @Test
  public void testExist() {
    log.info(replyService);
  }

  @Test
  public void testRegister() {
    ReplyDTO dto = replyService.toDTO(Reply.builder().replyer("권은비").board(Board.builder().bno(65L).build()).text("은비쨩").build());
    Long bno = replyService.register(dto);
    log.info(bno);
  }

  @Test
  public void testGet() {
    try{
      replyService.get(102L);
    }catch(IllegalArgumentException e){
      log.info(e.getMessage());
    }
  }

  @Test
  public void testModify() {
    ReplyDTO dto = replyService.toDTO(Reply.builder().rno(306L).replyer("권은비").text("은비쨩수정완료").board(Board.builder().bno(65L).build()).build());
    replyService.modify(dto);
  }

  @Test //삭제
  @DisplayName("삭제 테스트")
  public void testDelete() {
    replyService.remove(303L);
  }
}
