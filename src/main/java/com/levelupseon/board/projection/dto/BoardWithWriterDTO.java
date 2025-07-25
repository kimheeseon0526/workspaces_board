package com.levelupseon.board.projection.dto;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;

public interface BoardWithWriterDTO {
  Board getBoard();
  Member getMember();
}
