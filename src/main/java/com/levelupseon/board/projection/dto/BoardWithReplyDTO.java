package com.levelupseon.board.projection.dto;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Reply;

public interface BoardWithReplyDTO {
  Board getBoard();
  Reply getReply();
}
