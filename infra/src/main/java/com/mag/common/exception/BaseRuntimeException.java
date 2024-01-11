package com.mag.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BaseRuntimeException extends RuntimeException {

    private final ExceptionEnum error;

    private final String[] args;

}
