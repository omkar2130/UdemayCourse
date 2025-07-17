package com.udemy.accounts.dto;

import lombok.*;
import org.springframework.http.*;

import java.time.*;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMsg;
    private LocalDateTime errorTime;
}
