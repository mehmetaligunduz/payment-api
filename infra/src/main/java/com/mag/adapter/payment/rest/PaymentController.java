package com.mag.adapter.payment.rest;

import com.mag.adapter.payment.dto.PaymentRequest;
import com.mag.adapter.payment.rest.dto.PaymentResponse;
import com.mag.common.usecase.handler.UseCaseHandler;
import com.mag.port.payment.model.PaymentModel;
import com.mag.port.payment.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final UseCaseHandler<PaymentModel, PaymentUseCase> paymentUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentResponse> checkout(@RequestBody PaymentRequest paymentRequest) {

        final PaymentModel handle = paymentUseCaseHandler.handle(paymentRequest.toUseCase());

        return ResponseEntity.ok(PaymentResponse.toResponse(handle));
    }

}
