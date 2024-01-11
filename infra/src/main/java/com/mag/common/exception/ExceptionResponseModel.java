package com.mag.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseModel {

    private String code;

    private String message;

    private String detail;

    private HttpStatus status;

    private String path;

    private LocalDateTime timestamp;

}
