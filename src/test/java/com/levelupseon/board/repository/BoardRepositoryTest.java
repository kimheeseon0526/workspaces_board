package com.levelupseon.board.repository;

import com.levelupseon.board.projection.dto.*;
import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {
  @Autowired
  private BoardRepository repository;

  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);

  }

  @Test
  public void insertBoards() {
    IntStream.range(0, 100).forEach(i -> {
      Member member = Member.builder().email("user" + i + "@gmail.com").build();

      Board board = Board.builder()
              .title("title" + i)
              .content("content" + i)
              .writer(member)
              .build();

      repository.save(board);
    });
  }
  @Test
  @Transactional(readOnly = true) //수정 못함
  public void testRead() {
    Board board = repository.findById(3L).orElse(null);
    log.info(board);
    log.info(board.getWriter());
    //지연 로딩때문에 board sql 한 번 호출하고 그 후에 member sql 한 번 더 호출
    //총 2번이 따로 호출됨
    //wirter가 member에 포함되어있어서
  }

  @Test
  public void getBoardWithWriter() {
    //특정 게시글 번호로 게시글 + 작성자 정보 같이 조회
//    Arrays.stream((Object[]) repository.getBoardWithWriter(3L)).forEach(log::info);
    BoardWithWriterDTO dto = repository.getBoardWithWriter(3L);
    log.info(dto.getBoard()); //인터페이스 호출
    log.info(dto.getMember());
  }

  @Test
  public void getBoardWithWriter2() {
    BoardWithWriterDTORecord dto = repository.getBoardWithWriter2(3L);
    log.info(dto.board()); //인터페이스 호출
    log.info(dto.member());
  }

  @Test
  public void getBoardWithWriter3() {
    BoardWithWriterDTOClass dto = repository.getBoardWithWriter3(3L);
    log.info(dto.getBoard()); //인터페이스 호출
    log.info(dto.getMember());
  }

  @Test
  public void testGetBoardWithReply() {
    List<Object[]> list = repository.getBoardWithReply(3L);
//    list.stream().forEach( o ->log.info(Arrays.toString(o)));
    list.stream().forEach( o ->log.info("{} , {}" , o[0], o[1]));
    // List<Object[]> list = [object[0] = board, object[1] = reply] -> 댓글수만큼
    // -> 하나의 객체로 받으려고 하면 projection 사용
  }

  @Test
  public void testGetBoardWithReply2() {
    List<BoardWithReplyDTO> list = repository.getBoardWithReply2(3L);
    list.stream().forEach(log::info);
  }

  @Test
  public void testgetBoardWithReplyCount() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
    Page<BoardWithReplyCount> list = repository.getBoardWithReplyCount(pageable);
    list.stream().forEach(log::info);
  }

}
