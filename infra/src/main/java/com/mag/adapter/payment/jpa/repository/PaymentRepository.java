package com.mag.adapter.payment.jpa.repository;

import com.mag.adapter.payment.jpa.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
