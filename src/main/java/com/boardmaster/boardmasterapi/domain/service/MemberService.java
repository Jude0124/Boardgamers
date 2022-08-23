package com.boardmaster.boardmasterapi.domain.service;

public interface MemberService {
    //회원가입
    //로그인
    //로그아웃

    //아이디 찾기
    String findUserId(String email);
    //비밀번호 찾기
    String findPassword(String userId, String email);
    //비밀번호 변경
    String updatePassword(String email, String userId);
}
