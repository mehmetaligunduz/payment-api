package com.mag.port.card.usecase.handler;

import com.mag.common.DomainComponent;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.card.CardDataPort;
import com.mag.port.card.CardPort;
import com.mag.port.card.model.CardModel;
import com.mag.port.card.usecase.StoreCardUseCase;

@DomainComponent
public class StoreCardUseCaseHandler implements VoidUseCaseHandler<StoreCardUseCase> {

    private final CardPort cardPort;
    private final CardDataPort cardDataPort;

    public StoreCardUseCaseHandler(CardPort cardPort,
                                   CardDataPort cardDataPort) {
        this.cardPort = cardPort;
        this.cardDataPort = cardDataPort;
    }

    @Override
    public void handle(StoreCardUseCase useCase) {
        final CardModel cardModel = cardPort.storeCard(useCase);
        cardDataPort.storeCard(cardModel);
    }
}
