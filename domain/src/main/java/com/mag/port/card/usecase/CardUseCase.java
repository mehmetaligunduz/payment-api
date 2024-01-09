package com.mag.port.card.usecase;

import com.mag.common.usecase.UseCase;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardUseCase implements UseCase {

    private String holderName;

    private String number;

    private String expireYear;

    private String expireMonth;

    private String cvc;

}
