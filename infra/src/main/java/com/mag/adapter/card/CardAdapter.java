package com.mag.adapter.card;

import com.mag.port.card.CardPort;
import com.mag.port.card.model.CardModel;
import com.mag.port.card.usecase.DeleteCardUseCase;
import com.mag.port.card.usecase.StoreCardUseCase;
import io.craftgate.Craftgate;
import io.craftgate.request.DeleteStoredCardRequest;
import io.craftgate.request.StoreCardRequest;
import io.craftgate.response.StoredCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardAdapter implements CardPort {

    private final Craftgate craftgate;

    @Override
    public CardModel storeCard(StoreCardUseCase useCase) {
        final StoredCardResponse storedCardResponse = craftgate
                .payment()
                .storeCard(StoreCardRequest.builder()
                        .cardHolderName(useCase.getHolderName())
                        .cardNumber(useCase.getNumber())
                        .expireYear(useCase.getExpireYear())
                        .expireMonth(useCase.getExpireMonth())
                        .build());
        return
                new CardModel(storedCardResponse.getCardUserKey(),
                        storedCardResponse.getCardToken(),
                        storedCardResponse.getLastFourDigits(),
                        useCase.getAlias());
    }

    @Override
    public void deleteCard(DeleteCardUseCase useCase) {
        DeleteStoredCardRequest deleteStoredCardRequest = DeleteStoredCardRequest.builder()
                .cardUserKey(useCase.getUserKey())
                .cardToken(useCase.getToken())
                .build();
        craftgate.payment().deleteStoredCard(deleteStoredCardRequest);
        
    }
}
