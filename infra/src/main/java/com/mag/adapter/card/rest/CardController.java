package com.mag.adapter.card.rest;

import com.mag.adapter.card.rest.dto.StoreCardRequest;
import com.mag.common.usecase.handler.VoidUseCaseHandler;
import com.mag.port.card.usecase.DeleteCardUseCase;
import com.mag.port.card.usecase.StoreCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {

    private final VoidUseCaseHandler<StoreCardUseCase> storeCardVoidUseCaseHandler;

    private final VoidUseCaseHandler<DeleteCardUseCase> deleteCardVoidUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void storeCard(@RequestBody StoreCardRequest storeCardRequest) {

        storeCardVoidUseCaseHandler.handle(storeCardRequest.toUseCase());

    }

    @DeleteMapping("/{cardId}/delete-card")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCard(@PathVariable Long cardId) {

        deleteCardVoidUseCaseHandler.handle(new DeleteCardUseCase(cardId));

    }
}
