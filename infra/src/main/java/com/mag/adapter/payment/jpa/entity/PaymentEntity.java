package com.mag.adapter.payment.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
@EntityListeners({AuditingEntityListener.class})
public class PaymentEntity {

    @Id
    private Long id;

    private String conversationId;

    private BigDecimal price;

    @CreatedDate
    @Column(nullable = false, name = "created_at", updatable = false)
    private String createdAt;

}
