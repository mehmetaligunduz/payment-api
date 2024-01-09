package com.mag.adapter.card.rest.dto;

import com.mag.port.card.usecase.StoreCardUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreCardRequest {

    private String holderName;

    private String number;

    private String expireYear;

    private String expireMonth;

    private String alias;

    public StoreCardUseCase toUseCase() {
        return new StoreCardUseCase(
                getHolderName(),
                getNumber(),
                getExpireYear(),
                getExpireMonth(),
                getAlias()
        );
    }
}
