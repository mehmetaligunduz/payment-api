package com.mag.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionEnum {

    CARD_NOT_FOUND_ERROR("0001", "card not found", HttpStatus.NOT_FOUND),

    CARD_ALREADY_EXIST("0002", "card already exist", HttpStatus.BAD_REQUEST),

    CARD_ALREADY_DELETED("0003", "card already deleted", HttpStatus.BAD_REQUEST),

    CHECKOUT_PAYMENT_RETRIEVE_ERROR("0004", "checkout payment retrieve error", HttpStatus.INTERNAL_SERVER_ERROR),

    CRAFTGATE_EXTERNAL_ERROR("1001", "payment gateway error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;

    private final String messageKey;

    private final HttpStatus status;

}
