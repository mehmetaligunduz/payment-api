package com.mag.adapter.payment.exception;

import com.mag.common.exception.BaseRuntimeException;
import com.mag.common.exception.ExceptionEnum;

import java.util.function.Supplier;

public class PaymentFailedException extends BaseRuntimeException implements Supplier<PaymentFailedException> {

    public PaymentFailedException(ExceptionEnum exception, String... args) {

        super(exception, args);
    }

    @Override
    public PaymentFailedException get() {
        return this;
    }
}
