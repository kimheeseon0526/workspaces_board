package com.levelupseon.board.projection.dto;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;
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
