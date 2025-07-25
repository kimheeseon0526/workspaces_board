package com.levelupseon.board.repository;


import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTest {
  @Autowired
  private ReplyRepository repository;
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertReplies() {
    List<Long> bnos = boardRepository.findAll().stream().map(Board::getBno).toList();

    IntStream.range(0, 300).forEach(i -> {
      long bno = bnos.get(new Random().nextInt(bnos.size()));
      Board board = Board.builder().bno(bno).build();
      Reply reply = Reply.builder()
              .board(board)
              .text("reply" + i)
              .replyer("guest")
              .build();

      repository.save(reply);
    });
  }

  @Test
  public void testRead() {
    Reply reply = repository.findById(3L).orElse(null);
    log.info(reply);
    log.info(reply.getBoard());
    log.info(reply.getBoard().getWriter());
  }
}
