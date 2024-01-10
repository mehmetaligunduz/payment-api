package com.mag.adapter.payment;

import com.mag.port.payment.PaymentPort;
import com.mag.port.payment.model.PaymentModel;
import com.mag.port.payment.usecase.PaymentUseCase;
import io.craftgate.Craftgate;
import io.craftgate.model.Currency;
import io.craftgate.request.CreatePaymentRequest;
import io.craftgate.request.dto.Card;
import io.craftgate.request.dto.PaymentItem;
import io.craftgate.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentAdapter implements PaymentPort {

    private final Craftgate craftgate;

    @Override
    public PaymentModel checkout(PaymentUseCase useCase) {

        final CreatePaymentRequest paymentRequest = generateCreatePaymentRequest(useCase);

        final PaymentResponse paymentResponse = craftgate.payment().createPayment(paymentRequest);

        log.info("Payment retrieved - id:" + paymentResponse.getId());

        return
                new PaymentModel(
                        paymentResponse.getId(),
                        paymentResponse.getConversationId(),
                        paymentResponse.getPrice());
    }

    private static CreatePaymentRequest generateCreatePaymentRequest(PaymentUseCase useCase) {
        return CreatePaymentRequest
                .builder()
                .price(BigDecimal.valueOf(useCase.getPrice()))
                .paidPrice(BigDecimal.valueOf(useCase.getPrice()))
                .walletPrice(BigDecimal.valueOf(0))
                .installment(useCase.getInstallment())
                .conversationId(useCase.getConversationId())
                .card(Card.builder()
                        .cardHolderName(useCase.getCardUseCase().getHolderName())
                        .cardNumber(useCase.getCardUseCase().getNumber())
                        .expireYear(useCase.getCardUseCase().getExpireYear())
                        .expireMonth(useCase.getCardUseCase().getExpireMonth())
                        .cvc(useCase.getCardUseCase().getCvc())
                        .build())
                .items(useCase
                        .getItems()
                        .stream()
                        .map(x -> PaymentItem
                                .builder()
                                .name(x.getName())
                                .price(BigDecimal.valueOf(x.getPrice()))
                                .build()).toList())
                .currency(Currency.TRY)
                .build();
    }
}
