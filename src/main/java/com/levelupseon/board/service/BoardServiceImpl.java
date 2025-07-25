package com.levelupseon.board.service;

import com.levelupseon.board.dto.BoardDTO;
import com.levelupseon.board.dto.PageRequestDTO;
import com.levelupseon.board.dto.PageResponseDTO;
import com.levelupseon.board.entity.Board;
import com.levelupseon.board.entity.Member;
import com.levelupseon.board.projection.dto.BoardWithReplyCount;
import com.levelupseon.board.repository.BoardRepository;
import com.levelupseon.board.repository.ReplyRepository;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
public class BoardServiceImpl implements BoardService {
  private final BoardRepository boardRepository;
  private final ReplyRepository replyRepository;

  @Override
  public Long register(BoardDTO boardDTO) {
    return boardRepository.save(toEntity(boardDTO)).getBno();
    //toEntity를 통해 boardDTO 전달
  }

  @Override
  public PageResponseDTO<BoardDTO, BoardWithReplyCount> getList(PageRequestDTO pagerequestDTO) {
    return new PageResponseDTO<>(
            boardRepository.getBoardWithReplyCount(pagerequestDTO.getPageable(Sort.by(Sort.Direction.DESC, "bno")))
            , this::projectionToDTO /*bwrc -> toDTO(bwrc.board(), bwrc.member(), bwrc.replyCount())) */);

    //mapper, pageype 을 던져야함
  }

  @Override
  public BoardDTO get(Long bno) {
    return projectionToDTO(boardRepository.getBoardByBno((bno)));
  }

  @Transactional
  @Override
  public void remove(Long bno) {
    replyRepository.deleteByBoard_Bno(bno);
    boardRepository.deleteById(bno);

  }

  @Override
  public void modify(BoardDTO boardDTO) {
    //bno 받아와서 ~
    Board board = boardRepository.findById(boardDTO.getBno()).orElseThrow( () -> new IllegalStateException("해당 글 없음"));
    board.changeTitle(boardDTO.getTitle()); //1transaction
    board.changeContent(boardDTO.getContent()); //2transaction
    boardRepository.save(board);
  }
}
