package com.mag.port.card.usecase;

import com.mag.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreCardUseCase implements UseCase {

    private String holderName;

    private String number;

    private String expireYear;

    private String expireMonth;

    private String alias;
    
}