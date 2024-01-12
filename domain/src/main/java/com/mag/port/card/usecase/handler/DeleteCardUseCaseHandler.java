package com.mag.port.card.usecase.handler;

import com.mag.common.DomainComponent;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.card.CardPort;
import com.mag.port.card.usecase.DeleteCardUseCase;

@DomainComponent
public class DeleteCardUseCaseHandler implements VoidUseCaseHandler<DeleteCardUseCase> {

    private final CardPort cardPort;


    public DeleteCardUseCaseHandler(CardPort cardPort) {
        this.cardPort = cardPort;
    }

    @Override
    public void handle(DeleteCardUseCase useCase) {
        cardPort.deleteCard(useCase.getCardId());
    }
}
