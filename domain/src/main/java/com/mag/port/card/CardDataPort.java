package com.mag.port.card;

import com.mag.port.card.model.CardModel;

public interface CardDataPort {

    void storeCard(CardModel model);

    void deleteCard(String userKey, String token);

}
