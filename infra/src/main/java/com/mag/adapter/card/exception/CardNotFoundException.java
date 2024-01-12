package com.mag.adapter.card.exception;

import com.mag.common.exception.BaseRuntimeException;
import com.mag.common.exception.ExceptionEnum;

import java.util.function.Supplier;

public class CardNotFoundException extends BaseRuntimeException implements Supplier<CardNotFoundException> {


    public CardNotFoundException(ExceptionEnum exception, String... args) {
        super(exception, args);
    }

    @Override
    public CardNotFoundException get() {
        return this;
    }
}
