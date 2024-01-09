package com.mag.port.payment;

import com.mag.port.payment.usecase.PaymentUseCase;

public interface PaymentPort {

    void checkout(PaymentUseCase useCase);

}
