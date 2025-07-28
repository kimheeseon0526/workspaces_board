package com.levelupseon.board.domain.projection.dto;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Member;
import lombok.Getter;

@Getter
public class BoardWithWriterDTOClass {
  private final Board board;
  private final Member member;

  public BoardWithWriterDTOClass(Board board, Member member) {
    this.board = board;
    this.member = member;
  }
}
