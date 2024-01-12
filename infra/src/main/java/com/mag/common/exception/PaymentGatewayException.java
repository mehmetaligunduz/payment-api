package com.mag.common.exception;

import java.util.function.Supplier;

public class PaymentGatewayException extends BaseRuntimeException implements Supplier<PaymentGatewayException> {
    public PaymentGatewayException(ExceptionEnum exception, String... args) {
        super(exception, args);
    }

    @Override
    public PaymentGatewayException get() {
        return this;
    }
}
