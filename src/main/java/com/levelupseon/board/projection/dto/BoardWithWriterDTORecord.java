package com.levelupseon.board.projection.dto;

import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;

public record BoardWithWriterDTORecord(Board board, Member member) {
}
