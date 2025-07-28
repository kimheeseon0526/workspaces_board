package com.levelupseon.board.domain.projection.dto;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Reply;

public interface BoardWithReplyDTO {
  Board getBoard();
  Reply getReply();
}
