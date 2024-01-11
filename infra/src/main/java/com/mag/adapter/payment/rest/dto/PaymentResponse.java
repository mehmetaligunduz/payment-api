package com.mag.adapter.payment.rest.dto;

import com.mag.port.payment.model.PaymentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Long id;

    private String conversationId;

    private BigDecimal price;

    public static PaymentResponse toResponse(PaymentModel model) {

        return
                new PaymentResponse(
                        model.getId(),
                        model.getConversationId(),
                        model.getPrice());
    }

}
