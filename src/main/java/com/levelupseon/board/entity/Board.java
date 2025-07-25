package com.levelupseon.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Board extends BaseEntity{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bno;

  private String title;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)  //지연로딩
  private Member writer;

  //수정위한 setter -> 변경 가능한 애들만(즉, 제목과 내용만 변경 가능하기 때문에)
  public void changeTitle(String title) {
    this.title = title;
  }
  public void changeContent(String content) {
    this.content = content;
  }
}
