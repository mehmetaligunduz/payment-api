package com.mag.adapter.card;

import com.mag.adapter.card.exception.CardAlreadyDeletedException;
import com.mag.adapter.card.exception.CardNotFoundException;
import com.mag.adapter.card.jpa.entity.CardEntity;
import com.mag.adapter.card.jpa.entity.CardStatus;
import com.mag.adapter.card.jpa.repository.CardRepository;
import com.mag.common.exception.ExceptionEnum;
import com.mag.common.exception.PaymentGatewayException;
import com.mag.port.card.CardPort;
import com.mag.port.card.model.CardModel;
import com.mag.port.card.usecase.StoreCardUseCase;
import io.craftgate.Craftgate;
import io.craftgate.request.DeleteStoredCardRequest;
import io.craftgate.request.StoreCardRequest;
import io.craftgate.response.StoredCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardAdapter implements CardPort {

    private final Craftgate craftgate;

    private final CardRepository cardRepository;

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
    @Transactional
    public void deleteCard(Long cardId) {

        final Optional<CardEntity> card = cardRepository.findById(cardId);

        if (card.isEmpty()) {
            throw new CardNotFoundException(ExceptionEnum.CARD_NOT_FOUND_ERROR, cardId.toString().concat("idli card bulanamadı"));
        }

        if (CardStatus.DELETED.equals(card.get().getStatus())) {
            throw new CardAlreadyDeletedException(ExceptionEnum.CARD_ALREADY_DELETED, cardId.toString().concat("idli card zaten silinmiş"));
        }

        final CardEntity cardEntity = card.get();

        final DeleteStoredCardRequest deleteStoredCardRequest =
                DeleteStoredCardRequest
                        .builder()
                        .cardUserKey(cardEntity.getUserKey())
                        .cardToken(cardEntity.getToken())
                        .build();

        try {

            craftgate.payment().deleteStoredCard(deleteStoredCardRequest);

        } catch (Exception e) {

            throw new PaymentGatewayException(ExceptionEnum.CRAFTGATE_EXTERNAL_ERROR, e.getMessage());

        }

        cardRepository.updateById(cardId);

    }
}
