package com.mag.port.card.usecase.handler;

import com.mag.common.DomainComponent;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.card.CardDataPort;
import com.mag.port.card.CardPort;
import com.mag.port.card.usecase.DeleteCardUseCase;

@DomainComponent
public class DeleteCardUseCaseHandler implements VoidUseCaseHandler<DeleteCardUseCase> {

    private final CardPort cardPort;
    private final CardDataPort cardDataPort;

    public DeleteCardUseCaseHandler(CardPort cardPort, CardDataPort cardDataPort) {
        this.cardPort = cardPort;
        this.cardDataPort = cardDataPort;
    }

    @Override
    public void handle(DeleteCardUseCase useCase) {
        cardDataPort.deleteCard(useCase.getUserKey(), useCase.getToken());
        cardPort.deleteCard(useCase);
    }
}
