package com.boardmaster.boardmasterapi.api.form.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class ResponseForm {
    private String status;
    private String message;
    private DataForm data;
    private ErrorForm error;
}
