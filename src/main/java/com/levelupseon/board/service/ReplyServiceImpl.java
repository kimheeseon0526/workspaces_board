package com.levelupseon.board.service;

import com.levelupseon.board.domain.dto.ReplyDTO;
import com.levelupseon.board.domain.entity.Reply;
import com.levelupseon.board.domain.mapper.ReplyMapper;
import com.levelupseon.board.repository.ReplyRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ReplyServiceImpl implements ReplyService {
  private final ReplyMapper replyMapper;
  private final ReplyRepository replyRepository;

  @Override
  public Long register(ReplyDTO dto) {
    return replyRepository.save(replyMapper.toEntity(dto)).getRno();
  }

  @Override
  public List<ReplyDTO> getList(Long bno) {
    return replyRepository.findByBoard_BnoOrderByRno(bno).stream().map(replyMapper::toDto).toList();

  }

  @Override
  public void modify(ReplyDTO dto) {
    replyRepository.save(replyMapper.toEntity(dto));

  }

  @Override
  public void remove(Long rno) {
    replyRepository.deleteById(rno);
  }

  @Override
  public ReplyDTO get(Long rno) {
    return replyMapper.toDto(replyRepository.findById(rno).orElseThrow(() -> new IllegalArgumentException("댓글이 없음")));
  }

  @Override
  public Reply toEntity(ReplyDTO dto) {
    return replyMapper.toEntity(dto);
  }

  @Override
  public ReplyDTO toDTO(Reply reply) {
    return replyMapper.toDto(reply);
  }
}
