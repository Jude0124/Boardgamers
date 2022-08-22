package com.boardmaster.boardmasterapi;

import com.boardmaster.boardmasterapi.domain.Member;
import com.boardmaster.boardmasterapi.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 초기 데이터
 */
@Component
@RequiredArgsConstructor
public class initData {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = createMember();
        memberRepository.save(member);
    }

    public Member createMember() {
        Member member = Member.builder()
                .userId("junghui")
                .email("junghui@kakao.com")
                .password("123")
                .phone("01033023679")
                .nickname("정중헌")
                .build();

        return member;
    }
}
