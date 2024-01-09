package com.mag.adapter.payment.dto;


import com.mag.port.card.usecase.CardUseCase;
import com.mag.port.payment.usecase.PaymentUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private List<ItemsRequest> items;

    private CardRequest cardInformation;

    public PaymentUseCase toUseCase() {
        return PaymentUseCase
                .builder()
                .conversationId(UUID.randomUUID().toString())
                .price(
                        items.stream().mapToDouble(ItemsRequest::getPrice).sum()
                )
                .items(getItems().stream().map(ItemsRequest::toUseCase).toList())
                .cardUseCase(CardUseCase
                        .builder()
                        .holderName(cardInformation.getHolderName())
                        .number(cardInformation.getNumber())
                        .expireYear(cardInformation.getExpireYear())
                        .expireMonth(cardInformation.getExpireMonth())
                        .cvc(cardInformation.getCvc())
                        .build())
                .build();
    }

}
