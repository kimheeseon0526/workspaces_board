package com.levelupseon.board.repository;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

  void deleteByBoard_Bno(Long bno);
  //bno 기준으로 삭제 -> 타입이 long
}
