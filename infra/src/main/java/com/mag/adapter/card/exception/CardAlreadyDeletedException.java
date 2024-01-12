package com.mag.adapter.card.exception;

import com.mag.common.exception.BaseRuntimeException;
import com.mag.common.exception.ExceptionEnum;

import java.util.function.Supplier;

public class CardAlreadyDeletedException extends BaseRuntimeException implements Supplier<CardAlreadyDeletedException> {


    public CardAlreadyDeletedException(ExceptionEnum exception, String... args) {
        super(exception, args);
    }

    @Override
    public CardAlreadyDeletedException get() {
        return null;
    }
}
