package com.boardmaster.boardmasterapi.domain.repository;

import com.boardmaster.boardmasterapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByEmail(String email);
    Optional<Member> findMemberByUserId(String userId);
}
