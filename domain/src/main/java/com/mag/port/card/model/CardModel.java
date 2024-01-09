package com.mag.port.card.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardModel {

    private String userKey;

    private String token;

    private String lastFourDigit;

    private String alias;

}
