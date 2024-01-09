package com.mag.adapter.payment.rest;

import com.mag.adapter.payment.dto.PaymentRequest;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.payment.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final VoidUseCaseHandler<PaymentUseCase> paymentVoidUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void checkout(@RequestBody PaymentRequest paymentRequest) {
        paymentVoidUseCaseHandler.handle(paymentRequest.toUseCase());
    }

}
