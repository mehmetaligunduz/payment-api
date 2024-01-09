package com.mag.adapter.payment.dto;

import com.mag.port.payment.usecase.ItemsUseCase;
import io.craftgate.request.dto.PaymentItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsRequest {

    private String name;

    private Double price;

    public ItemsUseCase toUseCase() {
        return new ItemsUseCase(name, price);
    }

    public PaymentItem toPaymentItem() {
        return PaymentItem.builder()
                .name(getName())
                .price(BigDecimal.valueOf(getPrice()))
                .build();
    }

}
