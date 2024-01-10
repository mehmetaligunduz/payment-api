package com.mag.adapter.payment;

import com.mag.adapter.payment.jpa.entity.PaymentEntity;
import com.mag.adapter.payment.jpa.repository.PaymentRepository;
import com.mag.port.payment.PaymentDataPort;
import com.mag.port.payment.model.PaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentDataAdapter implements PaymentDataPort {

    private final PaymentRepository paymentRepository;

    @Override
    public void savePayment(PaymentModel paymentModel) {
        paymentRepository.save(
                new PaymentEntity(
                        paymentModel.getId(),
                        paymentModel.getConversationId(),
                        paymentModel.getPrice(),
                        null));
    }
}
