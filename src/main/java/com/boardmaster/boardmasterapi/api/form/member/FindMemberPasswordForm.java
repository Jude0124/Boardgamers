package com.boardmaster.boardmasterapi.api.form.member;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class FindMemberPasswordForm {
    @NotBlank(message = "아이디를 작성해 주세요")
    private String member_id;
    @NotBlank(message = "전화번호를 작성해주세요.")
    @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
    private String phone;
}
