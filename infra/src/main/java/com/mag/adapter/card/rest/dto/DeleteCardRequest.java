package com.mag.adapter.card.rest.dto;

import com.mag.port.card.usecase.DeleteCardUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCardRequest {

    private String userKey;

    private String token;

    public DeleteCardUseCase toUseCase() {
        return new DeleteCardUseCase(getUserKey(), getToken());
    }

}
