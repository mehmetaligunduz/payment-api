package com.mag.common.usecase.handler;

import com.mag.common.usecase.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T useCase);

}
