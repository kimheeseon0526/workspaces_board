package com.levelupseon.board.repository.search;

import com.levelupseon.board.domain.entity.Board;
import com.levelupseon.board.domain.projection.dto.BoardWithReplyCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository extends  SearchSupport<Board>{
  Board search1();

  Page<BoardWithReplyCount> searchPage(String type, String keyword, Pageable pageable);

}
