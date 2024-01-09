package com.mag.port.payment.usecase.handler;

import com.mag.common.DomainComponent;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.payment.PaymentPort;
import com.mag.port.payment.usecase.PaymentUseCase;

@DomainComponent
public class PaymentUseCaseHandler implements VoidUseCaseHandler<PaymentUseCase> {

    private final PaymentPort paymentPort;

    public PaymentUseCaseHandler(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @Override
    public void handle(PaymentUseCase useCase) {
        paymentPort.checkout(useCase);
    }
}
