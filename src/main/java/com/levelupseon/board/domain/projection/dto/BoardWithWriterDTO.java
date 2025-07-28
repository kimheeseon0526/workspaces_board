package com.levelupseon.board.domain.projection.dto;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Member;

public interface BoardWithWriterDTO {
  Board getBoard();
  Member getMember();
}
