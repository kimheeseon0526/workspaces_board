package com.levelupseon.board.service;

import com.levelupseon.board.dto.BoardDTO;
import com.levelupseon.board.dto.PageRequestDTO;
import com.levelupseon.board.dto.PageResponseDTO;
import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;
import com.levelupseon.board.projection.dto.BoardWithReplyCount;
import org.springframework.stereotype.Service;


public interface BoardService {
  Long register(BoardDTO boardDTO);

  PageResponseDTO<BoardDTO, BoardWithReplyCount> getList(PageRequestDTO pagerequestDTO);

  BoardDTO get(Long bno);

  //삭제
  void remove(Long bno);

  //수정
  void modify(BoardDTO boardDTO);

  //dml(insert, update)
  default Board toEntity(BoardDTO dto){
    return Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .content(dto.getContent())
            .writer(Member.builder().email(dto.getWriterEmail()).build())
            .build();
  }
  //select
  default BoardDTO toDTO(Board entity, Member member, Long replyCnt){
    return BoardDTO.builder()
            .bno(entity.getBno())
            .title(entity.getTitle())
            .content (entity.getContent())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .writerEmail(member.getEmail())
            .writerName(member.getName())
            .replyCount(replyCnt)
            .build();
  }

  default BoardDTO projectionToDTO(BoardWithReplyCount entity) {
    return BoardDTO.builder()
            .bno(entity.getBoard().getBno())
            .title(entity.getBoard().getTitle())
            .content (entity.getBoard().getContent())
            .regDate(entity.getBoard().getRegDate())
            .modDate(entity.getBoard().getModDate())
            .writerEmail(entity.getBoard().getWriter().getEmail())
            .writerName(entity.getBoard().getWriter().getName())
            .replyCount(entity.getReplyCount())
            .build();
  }

}
