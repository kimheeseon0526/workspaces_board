package com.levelupseon.board.repository;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

  void deleteByBoard_Bno(Long bno);
  //bno 기준으로 삭제 -> 타입이 long

  List<Reply> findByBoard_BnoOrderByRno(Long bno);
  List<Reply> findByBoard(Board  board);
}
