package com.boardmaster.boardmasterapi.api.controller;

import com.boardmaster.boardmasterapi.api.form.member.FindMemberIdForm;
import com.boardmaster.boardmasterapi.api.form.member.FindMemberPasswordForm;
import com.boardmaster.boardmasterapi.domain.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bm")
public class MemberController {
    private final DefaultMessageService messageService;
    private final MemberService memberService;

    @PostMapping("/find/id")
    public String findMemberId(@RequestBody @Valid FindMemberIdForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            bindingResult.reject("NotEmailFormat", "이메일 형식이 아닙니다.");
        }

        String userId = memberService.findUserId(form.getEmail());

        if(userId == null) {
            bindingResult.reject("findIdFail", "해당 이메일이 없습니다.");
        }

        return userId;
    }

    @PostMapping("/find/password")
    public String findPassword(@RequestBody @Valid FindMemberPasswordForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.reject("NotFormat", "지원하는 형식이 아닙니다.");
        }

        String token = memberService.findPassword(form.getMember_id(), form.getPhone());

        if (token == null) {
            bindingResult.reject("findFailPassword", "인증번호 발급이 불가합니다.");
        }
        Message message = new Message();
        message.setFrom("01065228834");
        message.setTo("01065228834");
        message.setText("보드마스터 비밀번호 찾기 인증번호: "+ token);
        messageService.sendOne(new SingleMessageSendingRequest(message));

        return token;
    }
}
