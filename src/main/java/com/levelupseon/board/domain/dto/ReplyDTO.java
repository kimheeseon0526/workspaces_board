package com.levelupseon.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
  private Long rno;
  private String text;
  private String replyer;
  private Long bno;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
}
