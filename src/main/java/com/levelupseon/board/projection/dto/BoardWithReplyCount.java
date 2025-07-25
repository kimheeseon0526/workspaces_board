package com.levelupseon.board.projection.dto;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardWithReplyCount {
  private Board board;
  private Member member;
  private Long replyCount;

  public BoardWithReplyCount(Board board, Member member, Long replyCount) {
    this.board = board;
    this.member = member;
    this.replyCount = replyCount;
  }
}
