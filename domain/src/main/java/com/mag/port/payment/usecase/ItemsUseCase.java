package com.mag.port.payment.usecase;

import com.mag.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsUseCase implements UseCase {

    private String name;

    private Double price;

}
