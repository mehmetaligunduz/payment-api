package com.mag.adapter.card;

import com.mag.adapter.card.jpa.entity.CardEntity;
import com.mag.adapter.card.jpa.repository.CardRepository;
import com.mag.port.card.CardDataPort;
import com.mag.port.card.model.CardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                        model.getAlias()));
    }

    @Override
    @Transactional
    public void deleteCard(String userKey, String token) {
        cardRepository.deleteByUserKeyAndToken(userKey, token);
    }

}
