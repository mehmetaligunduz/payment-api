package com.mag.adapter.card;

import com.mag.adapter.card.jpa.entity.CardEntity;
import com.mag.adapter.card.jpa.entity.CardStatus;
import com.mag.adapter.card.jpa.repository.CardRepository;
import com.mag.port.card.CardDataPort;
import com.mag.port.card.model.CardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDataAdapter implements CardDataPort {

    private final CardRepository cardRepository;

    @Override
    public void storeCard(CardModel model) {
        cardRepository.save(
                new CardEntity(
                        null,
                        model.getUserKey(),
                        model.getToken(),
                        model.getLastFourDigit(),
                        model.getAlias(),
                        CardStatus.ACTIVE));
    }

}
