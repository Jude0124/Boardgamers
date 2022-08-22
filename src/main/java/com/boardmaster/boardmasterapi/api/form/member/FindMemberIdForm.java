package com.boardmaster.boardmasterapi.api.form.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMemberIdForm {
    @NotBlank(message = "이메일을 작성해주세요.")
    @Email
    private String email;
}
