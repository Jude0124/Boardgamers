package com.boardmaster.boardmasterapi.domain.service;

import com.boardmaster.boardmasterapi.domain.Member;
import com.boardmaster.boardmasterapi.domain.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceImplTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("아이디 찾기")
    @Transactional
    void 아이디찾기() {
        String userId = memberService.findUserId("dlwlrma@kakao.com");
        Assertions.assertThat(userId).isEqualTo("dlwlrma");
    }
}