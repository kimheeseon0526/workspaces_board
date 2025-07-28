package com.levelupseon.board.domain.projection.dto;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.entity.Member;
import lombok.Getter;
import lombok.ToString;

public record BoardWithReplyCount (Board board, Member member, Long replyCount){}


//  public BoardWithReplyCount(Board board, Member member, Long replyCount) {
//    this.board = board;
//    this.member = member;
//    this.replyCount = replyCount;
//  }

