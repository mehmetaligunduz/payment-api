package com.mag.port.payment;

import com.mag.port.payment.model.PaymentModel;

public interface PaymentDataPort {

    void savePayment(PaymentModel paymentModel);
}
