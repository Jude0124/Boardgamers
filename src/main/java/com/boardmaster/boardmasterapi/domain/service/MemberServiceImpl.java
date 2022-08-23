package com.boardmaster.boardmasterapi.domain.service;

import com.boardmaster.boardmasterapi.domain.Member;
import com.boardmaster.boardmasterapi.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public String findUserId(String email) {

        log.info("아이디 찾기 실행 email={}", email);
        Optional<Member> findMember = memberRepository.findMemberByEmail(email);

        return findMember.stream()
                .findAny()
                .filter(m -> m.getEmail().equals(email))
                .orElseThrow(IllegalArgumentException::new)
                .getUserId();
    }

    @Override
    public String findPassword(String userId, String phone) {

        log.info("비밀번호 찾기 실행 userId={}, email={}", userId, phone);
        Optional<Member> findMember = memberRepository.findMemberByUserId(userId);

        String findPhone = findMember.stream()
                .findAny()
                .filter(m -> m.getUserId().equals(userId))
                .orElseThrow(IllegalArgumentException::new)
                .getPhone();

        if(findPhone.equals(phone)) {
            return UUID.randomUUID().toString();
        }

        throw new IllegalArgumentException("유효한 아이디가 없습니다.");
    }

    @Override
    public String updatePassword(String email, String userId) {
        return null;
    }
}
