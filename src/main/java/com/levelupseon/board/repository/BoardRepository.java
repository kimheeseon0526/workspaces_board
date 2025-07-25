package com.levelupseon.board.repository;

import com.levelupseon.board.projection.dto.*;
import com.levelupseon.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
  @Query("select b board, w as member from Board b left join b.writer w where b.bno = :bno")
  BoardWithWriterDTO getBoardWithWriter(@Param("bno") Long bno);

  @Query("select b board, w as member from Board b left join b.writer w where b.bno = :bno")
  BoardWithWriterDTORecord getBoardWithWriter2(@Param("bno") Long bno);

  @Query("select b board, w as member from Board b left join b.writer w where b.bno = :bno")
  BoardWithWriterDTOClass getBoardWithWriter3(@Param("bno") Long bno);

  @Query("select b board, r reply from Board b left join Reply r on r.board = b where b.bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);

  @Query("select b board, r reply from Board b left join Reply r on r.board = b where b.bno = :bno")
  List<BoardWithReplyDTO> getBoardWithReply2(@Param("bno") Long bno);
  //BoardWithReplyDTO 인터페이스에 getBoard, getMember 있음

  //게시글 목록 조회 + 각 게시글에 달린 댓글 수
//  @Query(value = "select b board, w writer, count(r) replyCount from Board b left join b.writer w " +
//          "left join Reply r on r.board = b group by b"
//          , countQuery = "select count(b) from Board b")
//  Page<BoardWithReplyCountDTO> getBoardWithReplyCount(Pageable pageable);

  @Query(value = "select b board, w as member, count(r) replyCount from Board b left join b.writer w " +
          "left join Reply r on r.board = b group by b"
          , countQuery = "select count(b) from Board b")
  Page<BoardWithReplyCount> getBoardWithReplyCount(Pageable pageable);

  @Query("select b board, w as member, count(r) replyCount from Board b left join b.writer w " +
          "left join Reply r on r.board = b where b.bno = :bno")
  BoardWithReplyCount getBoardByBno(Long bno);

}
