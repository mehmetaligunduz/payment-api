package com.mag.common.exception.handler;

import com.mag.common.exception.BaseRuntimeException;
import com.mag.common.exception.ExceptionEnum;
import com.mag.common.exception.ExceptionResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseRuntimeException.class)
    private ResponseEntity<ExceptionResponseModel> handleInfraException(BaseRuntimeException exception) {

        log.error("Exception occurred, {}", getExceptionDetailMessage(exception.getArgs()));

        var errorEnum = exception.getError();

        final var response = prepareResponseModel(exception.getError(), exception);

        return new ResponseEntity<>(response, errorEnum.getStatus());

    }

    public ExceptionResponseModel prepareResponseModel(ExceptionEnum exceptionEnum, BaseRuntimeException exception) {
        return new ExceptionResponseModel(
                exceptionEnum.getCode(),
                exceptionEnum.getMessageKey(),
                getExceptionDetailMessage(exception.getArgs()),
                exceptionEnum.getStatus(),
                exception.getClass().getSimpleName(),
                LocalDateTime.now());
    }

    public String getExceptionDetailMessage(String[] args) {
        return args[0];
    }

}
