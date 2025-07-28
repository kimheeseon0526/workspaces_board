package com.levelupseon.board.service;

import com.levelupseon.board.domain.dto.ReplyDTO;
import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Reply;

import java.util.List;

public interface ReplyService {

  ReplyDTO get(Long rno);
  //댓글 등록
  Long register(ReplyDTO replyDTO);

  //특정 게시글의 댓글 등록
  List<ReplyDTO> getList(Long bno);

  //댓글 수정
  void modify(ReplyDTO replyDTO);

  //댓글 삭제
  void remove(Long rno);

  //ReplyDTO를 reply 객체로 변환 Board 객체의 처리 수반됨?
  Reply toEntity(ReplyDTO dto);
  ReplyDTO toDTO(Reply reply);
}
