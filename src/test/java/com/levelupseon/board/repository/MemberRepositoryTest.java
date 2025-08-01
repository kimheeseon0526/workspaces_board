package com.levelupseon.board.repository;


import com.levelupseon.board.domain.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {
  @Autowired
  private MemberRepository repository;

  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertMembers() {
    IntStream.range(0, 100).forEach(i -> {
      Member member = Member.builder()
              .email("user" + i + "@gmail.com")
              .password("1111")
              .name("USER" + i)
              .build();

      repository.save(member);
    });
  }
}
