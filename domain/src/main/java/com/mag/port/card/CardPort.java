package com.mag.port.card;

import com.mag.port.card.model.CardModel;
import com.mag.port.card.usecase.StoreCardUseCase;

public interface CardPort {

    CardModel storeCard(StoreCardUseCase useCase);

    void deleteCard(Long cardId);

}
