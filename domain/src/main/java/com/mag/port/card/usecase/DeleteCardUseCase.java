package com.mag.port.card.usecase;

import com.mag.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCardUseCase implements UseCase {

    private Long cardId;

}
