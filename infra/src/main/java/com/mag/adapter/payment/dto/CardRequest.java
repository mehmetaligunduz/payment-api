package com.mag.adapter.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    private String holderName;

    private String number;

    private String expireYear;

    private String expireMonth;

    private String cvc;

}
