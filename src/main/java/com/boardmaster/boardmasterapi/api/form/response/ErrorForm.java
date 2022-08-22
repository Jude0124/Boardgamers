package com.boardmaster.boardmasterapi.api.form.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorForm {
    private String code;
    private String message;
}
