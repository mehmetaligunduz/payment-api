package com.mag.common.usecase.handler;

import com.mag.common.usecase.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);

}
