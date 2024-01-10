package com.mag.port.payment;

import com.mag.port.payment.model.PaymentModel;
import com.mag.port.payment.usecase.PaymentUseCase;

public interface PaymentPort {

    PaymentModel checkout(PaymentUseCase useCase);

}
