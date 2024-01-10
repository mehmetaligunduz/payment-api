package com.mag.port.payment.usecase;

import com.mag.common.usecase.UseCase;
import com.mag.port.card.usecase.CardUseCase;
import com.mag.port.payment.usecase.enums.Currency;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUseCase implements UseCase {

    private String conversationId;

    private Double price;

    private Double paidPrice = getPrice();

    private Double walletPrice;

    @Builder.Default
    private int installment = 1;

    private Currency currency = Currency.TRY;

    private List<ItemsUseCase> items;

    private CardUseCase cardUseCase;

}
