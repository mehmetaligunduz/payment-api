package com.mag.port.payment.usecase.handler;

import com.mag.common.DomainComponent;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.payment.PaymentDataPort;
import com.mag.port.payment.PaymentPort;
import com.mag.port.payment.model.PaymentModel;
import com.mag.port.payment.usecase.PaymentUseCase;

@DomainComponent
public class PaymentUseCaseHandler implements VoidUseCaseHandler<PaymentUseCase> {

    private final PaymentPort paymentPort;

    private final PaymentDataPort paymentDataPort;

    public PaymentUseCaseHandler(PaymentPort paymentPort,
                                 PaymentDataPort paymentDataPort) {
        this.paymentPort = paymentPort;
        this.paymentDataPort = paymentDataPort;
    }

    @Override
    public void handle(PaymentUseCase useCase) {
        final PaymentModel checkout = paymentPort.checkout(useCase);
        paymentDataPort.savePayment(checkout);

    }
}
